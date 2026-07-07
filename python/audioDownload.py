import subprocess
import time
import os

# Your playlist URL
playlist_url = "https://www.youtube.com/watch?v=2Vv-BfVoq4g&list=RDrtOvBOTyX00&index=2"

# Custom directory to save downloaded files
download_dir = "./general/folkAndBanjaraSongs"

# Create directory if it doesn't exist
os.makedirs(download_dir, exist_ok=True)
video_ids = ["W0DM5lcj6mw,0GVExpdmoDs,JGwWNGJdvx8,D-YDEyuDxWU,JgDNFQ2RaLQ,cNGjD0VG4R8,3Kxf2dHlDpQ,byxFUKxhT3s,AX6OrbgS8lI,HrnrqYxYrbk"]

# Fetch video IDs
# print("Fetching video list from playlist...")
# result = subprocess.run([
#     "yt-dlp",
#     "--flat-playlist",
#     "--print", "id",
#     playlist_url
# ], capture_output=True, text=True)

# video_ids = result.stdout.strip().split("\n")
print(f"Found {len(video_ids)} videos. Starting downloads...\n")

for index, video_id in enumerate(video_ids, start=1):
    video_url = f"https://www.youtube.com/watch?v={video_id}"

    # Use yt-dlp to get the title without downloading
    info_result = subprocess.run([
        "yt-dlp",
        "--get-title",
        video_url
    ], capture_output=True, text=True)
    title = info_result.stdout.strip()
    safe_title = "".join(c for c in title if c.isalnum() or c in " -_").strip()[:40]

    output_filename = f"{index:02d} - {safe_title}.mp3"
    output_path = os.path.join(download_dir, output_filename)

    if os.path.exists(output_path):
        print(f"Skipping ({index}): Already exists - {output_path}")
        continue

    print(f"Downloading ({index}/{len(video_ids)}): {video_url}")
    subprocess.run([
        "yt-dlp",
        "-f", "bestaudio[ext=m4a]",
        "--extract-audio",
        "--audio-format", "mp3",
        "--audio-quality", "0",
        "--user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)",
        "--no-part",
        "-o", output_path,
        video_url
    ])

    print("Sleeping for 10 seconds to avoid rate limiting...\n")
    time.sleep(10)
