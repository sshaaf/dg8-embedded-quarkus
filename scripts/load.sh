#!/usr/bin/env bash
export EP=http://localhost:8080/api
#export EP=http://jcache-quarkus-test.apps.cluster-cph-5bcc.cph-5bcc.example.opentlc.com/api

curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"course":"Bethpage","score":64,"playerId":"1","playerName":"Gary Player","country":"SA"}' \
  $EP
echo " "

curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"course":"Bethpage","score":61,"playerId":"2","playerName":"Jack Niklaus","country":"USA"}' \
  $EP

curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"course":"TheOpen","score":55,"playerId":"3","playerName":"Homero Blancas","country":"Spain"}' \
  $EP

curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"course":"TheOpen","score":58,"playerId":"4","playerName":"Tiger Woods","country":"USA"}' \
  $EP


curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"course":"TheOpen","score":57,"playerId":"5","playerName":"Colin Montgomery","country":"UK"}' \
  $EP



echo " "