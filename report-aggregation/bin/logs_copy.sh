#!/bin/bash
path=$1
num=1

## Create folder if not present
mkdir -p $path/final-logs
rm -r $path/final-logs/export
mkdir -p $path/final-logs/export


for _dir in $path/gatling-*/
do
  echo ${_dir}
  cp ${_dir}simulation.log  $path/final-logs/export/$num-$HOSTNAME-simulation.log
  num=$((num+1))
done