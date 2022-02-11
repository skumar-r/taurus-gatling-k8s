# Running Gatling tests with Taurus

Running the Samples
-------------------
1. Make sure that the volumes 'configs' and 'artifacts' are updated with actual path  based on running environment
2. Copy the contents from 'sample-configs' folder to the 'configs' volume 
3. To try with single pod 
    a. 'kubectl apply -f taurus-pod-.yaml' 
4. To run multiple pods 
    a. Run ' taurus_pod_create.sh no_of_pods'.  for starting 2 pods, ./taurus_pod_create.sh 2