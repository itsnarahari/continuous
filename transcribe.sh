#!/bin/bash

cd ~/Documents/interview-recordings || exit 1

FILE="$1"

if [ -z "$FILE" ]; then
    echo "Usage: ./transcribe.sh recording.m4a"
    exit 1
fi

BASE="${FILE%.*}"

echo "Converting audio to WAV..."

if ! ffmpeg -i "$FILE" -ar 16000 -ac 1 -c:a pcm_s16le "${BASE}.wav" -y; then
    echo "Audio conversion failed."
    exit 1
fi

echo "Starting transcription..."

if whisper-cli \
  -m ~/whisper-models/ggml-large-v3-turbo.bin \
  -f "${BASE}.wav" \
  -l en \
  -t 8 \
  -otxt \
  -of "${BASE}"; then

    rm -f "${BASE}.wav"
    echo "Success! Transcript: ${BASE}.txt"
    echo "Temporary WAV file deleted."

else
    echo "Transcription failed. WAV file retained for troubleshooting."
    exit 1
fi