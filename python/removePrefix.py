import os
import re

folder_path = "./"  # or provide absolute path

# Set of supported audio formats
audio_extensions = {".mp3", ".m4a", ".aac", ".wav", ".flac", ".ogg"}

# Regex to match patterns like "03 - ", "12 - ", etc.
pattern = re.compile(r"^\d+\s*-\s*")

for filename in os.listdir(folder_path):
    file_ext = os.path.splitext(filename)[1].lower()

    if file_ext in audio_extensions:
        new_name = pattern.sub("", filename)

        if new_name != filename:
            old_path = os.path.join(folder_path, filename)
            new_path = os.path.join(folder_path, new_name)

            # Rename file
            os.rename(old_path, new_path)
            print(f"Renamed: {filename} → {new_name}")
