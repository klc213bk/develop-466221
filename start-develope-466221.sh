#!/bin/bash

java -jar -Dspring.profiles.active=dev target/develop-466221-1.0.jar --spring.config.location=file:config/ 
