#!/bin/bash

URL="http://192.168.58.2:31260/version"

echo "Starting 10 requests to $URL..."
echo "-----------------------------------"

for i in {1..10}
do
   echo "Request #$i:"
   curl -s $URL
   echo -e "\n-----------------------------------"
   sleep 1
done

echo "Test complete."
