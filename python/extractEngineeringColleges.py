
#!/usr/bin/env python3
"""
TGEAPCET Engineering College Extractor
--------------------------------------
Requirements:
    pip install requests beautifulsoup4 pandas openpyxl lxml tqdm

Output:
    output/tgeapcet_2026.xlsx
"""

import re
from pathlib import Path

import pandas as pd
import requests
from bs4 import BeautifulSoup
from tqdm import tqdm

BASE = "https://tgeapcet.nic.in"
PROFILE_URL = f"{BASE}/institute_profile.aspx"

HEADERS = {
    "User-Agent": "Mozilla/5.0"
}

session = requests.Session()
session.headers.update(HEADERS)


def clean(txt):
    return re.sub(r"\s+", " ", txt.replace("\xa0", " ")).strip()


def get(url):
    r = session.get(url, timeout=30)
    r.raise_for_status()
    return BeautifulSoup(r.text, "lxml")


def parse_profile():
    soup = get(PROFILE_URL)

    print("Total tables:", len(soup.find_all("table")))

    for i, table in enumerate(soup.find_all("table")):
        print(f"\nTABLE {i}")
        print(table.get_text(" ", strip=True)[:300])

    return 0;


def parse_details(college):
    soup = get(college["URL"])

    info = {
        "Affiliation": "",
        "Website": "",
        "Hostel": "",
        "Year": "",
        "Address": ""
    }

    for tr in soup.find_all("tr"):
        tds = tr.find_all("td")
        texts = [clean(x.get_text(" ", strip=True)) for x in tds]

        if len(texts) >= 4:
            if texts[2].startswith("Affilited"):
                info["Affiliation"] = texts[3]
            elif texts[2].startswith("Year of Establishment"):
                info["Year"] = texts[3]

            if texts[0].startswith("Hostel Availability"):
                info["Hostel"] = texts[1]

            if "Visit Website" in texts[0]:
                info["Website"] = texts[1]

    # address
    addr = []
    for td in soup.find_all("td"):
        if "Address of the College" in td.get_text():
            inner = td.find("table")
            if inner:
                for r in inner.find_all("tr"):
                    x = clean(r.get_text())
                    if x:
                        addr.append(x)
            break
    info["Address"] = ", ".join(addr)

    course_table = None
    for t in soup.find_all("table"):
        if "Branch Code" in t.get_text():
            course_table = t
            break

    courses = []

    if course_table:
        for tr in course_table.find_all("tr")[1:]:
            tds = tr.find_all("td")
            if len(tds) < 6:
                continue

            courses.append({
                **college,
                **info,
                "Branch Code": clean(tds[1].text),
                "Branch Name": clean(tds[2].text),
                "Intake": clean(tds[3].text),
                "Fee": clean(tds[4].text),
                "Self Finance": clean(tds[5].text),
                "Autonomous": "AUTONOMOUS" in college["College Name"].upper()
            })

    return info, courses


def autosize(ws):
    from openpyxl.utils import get_column_letter

    for col in ws.columns:
        length = max(len(str(c.value or "")) for c in col)
        ws.column_dimensions[get_column_letter(col[0].column)].width = min(length + 3, 60)
    ws.freeze_panes = "A2"
    ws.auto_filter.ref = ws.dimensions


def main():
    print("Reading institute profile...")
    colleges = parse_profile()

    print(f"Found {len(colleges)} colleges")

    college_rows = []
    course_rows = []

    for c in tqdm(colleges):
        try:
            info, courses = parse_details(c)
            college_rows.append({**c, **info})
            course_rows.extend(courses)
        except Exception as ex:
            print(f"Failed: {c['College Code']} -> {ex}")

    college_df = pd.DataFrame(college_rows)
    course_df = pd.DataFrame(course_rows)

    master_df = course_df.copy()

    cse_codes = ["CSE","CSM","CSD","CSC","CSB","AID","AI","AIM","CIC","CSO","IT"]
    hyd = ["HYD","RR","MDL"]

    outdir = Path("output")
    outdir.mkdir(exist_ok=True)

    outfile = outdir / "tgeapcet_2026.xlsx"

    with pd.ExcelWriter(outfile, engine="openpyxl") as writer:
        college_df.to_excel(writer, sheet_name="Colleges", index=False)
        course_df.to_excel(writer, sheet_name="Courses", index=False)
        master_df.to_excel(writer, sheet_name="Master", index=False)
        master_df[master_df["District"].isin(hyd)].to_excel(writer, sheet_name="Hyderabad", index=False)
        master_df[master_df["Autonomous"]].to_excel(writer, sheet_name="Autonomous", index=False)
        master_df[master_df["Branch Code"].isin(cse_codes)].to_excel(writer, sheet_name="CSE Branches", index=False)

        for ws in writer.book.worksheets:
            autosize(ws)

    print("Done!")
    print(outfile.resolve())


if __name__ == "__main__":
    main()
