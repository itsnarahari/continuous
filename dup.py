import os

# Folder where your music files are stored
folder_path = "./general/folkAndBanjaraSongs"

# Valid audio file extensions
audio_extensions = {".mp3", ".m4a", ".aac", ".wav", ".flac", ".ogg"}

# Store filenames after removing prefix (to detect duplicates)
seen = set()

# Loop through all files in the folder
for filename in os.listdir(folder_path):
    file_ext = os.path.splitext(filename)[1].lower()

    # Skip if not an audio file
    if file_ext not in audio_extensions:
        continue

    # Remove prefix like "03 - " by splitting on the first " - "
    parts = filename.split(" - ", 1)
    base_name = parts[1] if len(parts) == 2 else filename

    # If the base name is already seen, it's a duplicate → delete
    if base_name in seen:
        file_to_delete = os.path.join(folder_path, filename)
        print(f"Duplicate found: {filename} → Deleting")
        os.remove(file_to_delete)
    else:
        seen.add(base_name)
