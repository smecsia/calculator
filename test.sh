#!/bin/bash
./stop.sh
mvn clean package
cd backend
mvn jetty:run &
sleep 10
cd ../frontend
mvn test -Pwith-integration-test
