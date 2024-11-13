#!/bin/bash

URL="http://localhost:8080"

MAX_RETRIES=30
RETRY_INTERVAL=5

for ((i=1; i<=MAX_RETRIES; i++)); do
  echo "Checking if app is ready (Attempt $i/$MAX_RETRIES)..."
  if curl --silent --fail "$URL" > /dev/null; then
    echo "App is ready!"
    exit 0
  fi
  echo "App is not ready, retrying in $RETRY_INTERVAL seconds..."
  sleep $RETRY_INTERVAL
done

echo "App did not become ready in time. Exiting..."
exit 1
