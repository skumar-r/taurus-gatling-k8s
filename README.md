# Running Gatling tests with Taurus

Running the Samples
-------------------
1. Make sure that the volumes 'configs' and 'artifacts' are updated with actual path  based on running environment in the taurus-pod-.yaml and taurus-pod-template.yaml
2. Copy the contents from 'sample-configs' folder to the 'configs' volume 
3. To try with single pod 
    a. 'kubectl apply -f taurus-pod-.yaml' 
4. To run multiple pods 
    a. Run ' taurus_pod_create.sh no_of_pods'.  for starting 2 pods, ./taurus_pod_create.sh 2



Report Aggregation
------------------

If we ran multiple pods, then each of them would have generated the simulation.log in a particular folder and we need to aggregate them and feed to gatling executable for the generation of final html report

1. Go to '/report-aggregation/bin/ folder and execute './logs_copy.sh'  with the the absolute path of the 'artifacts' ( folder which is mounted for the artifacts volume in the taurus pod ) folder as the argument. 
Example:  ./logs_copy.sh /d/GitRepo/taurus-gatling-k8s/artifacts

2. Go back to '/report-aggregation' folder and run 'docker compose build'

3. Then run ' docker compose up'
