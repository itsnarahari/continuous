import subprocess
import os

# Download to Mac Documents folder
download_dir = os.path.expanduser("~/Documents/audio/FolkAndBanjaraSongs")
os.makedirs(download_dir, exist_ok=True)

video_id = "3L9cTkV6blY"  # Change to your desired video ID
video_url = f"https://www.youtube.com/watch?v={video_id}"

# Get video title
info_result = subprocess.run([
    "yt-dlp",
    "--get-title",
    video_url
], capture_output=True, text=True)

title = info_result.stdout.strip()
safe_title = "".join(c for c in title if c.isalnum() or c in " -_").strip()[:40]
output_filename = f"{safe_title}.%(ext)s"
output_path = os.path.join(download_dir, output_filename)

final_file_path = os.path.join(download_dir, f"{safe_title}.mp4")
if os.path.exists(final_file_path):
    print(f"Already exists: {final_file_path}")
else:
    print(f"Downloading in up to 4K: {video_url} -> {final_file_path}")
    subprocess.run([
        "yt-dlp",
        "-f", "bestvideo[height<=2160][ext=mp4]+bestaudio[ext=m4a]/best",
        "--merge-output-format", "mp4",
        "--user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)",
        "--no-part",
        "-o", output_path,
        video_url
    ])
