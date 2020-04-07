#!/usr/bin/env bash
curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"card":[5,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"currentHole":3,"playerId":"4","playerName":"test1"}' \
  http://localhost:8080/api

curl --header "Content-Type: application/json" \
  --request PATCH \
  -d '{"card":[5,4,4,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"currentHole":4,"playerId":"4","playerName":"test1"}' \
  http://localhost:8080/api/4
