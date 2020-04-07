#!/usr/bin/env bash
export EP=http://localhost:8080/api
#export EP=http://jcache-quarkus-test.apps.cluster-cph-5bcc.cph-5bcc.example.opentlc.com/api

curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"card":[5,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"currentHole":3,"playerId":"4","playerName":"test1"}' \
  $EP

curl --header "Content-Type: application/json" \
  --request PATCH \
  -d '{"card":[5,4,4,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"currentHole":4,"playerId":"4","playerName":"test1"}' \
  $EP/4
