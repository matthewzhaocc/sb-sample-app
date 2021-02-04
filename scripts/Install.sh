#!/bin/bash
mv scripts/sb-sample-app.service /lib/systemd/system/
mv target/sample-app-0.0.1-SNAPSHOT.jar /app/app.jar
systemctl daemon-reload
systemctl restart sb-sample-app