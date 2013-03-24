#!/bin/bash
./stop.sh
mvn clean package
cd backend
mvn jetty:run &
cd ../frontend
mvn jetty:run &
sleep 30
chromium-browser http://localhost:9090
