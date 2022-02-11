#!/bin/bash

no_instances=$1

for (( i=1; i<=$no_instances; i++ ));
do
  sed "s/{{test-pod-name}}/taurus-pod-$i/g" taurus-pod-template.yaml | kubectl apply -f - ;
done
