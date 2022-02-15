#!/bin/bash

set -e
pwd

>&2 echo "Starting report generation using Gatling bundle"
bin/gatling.sh -ro export