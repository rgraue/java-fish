# !/bin/bash

DETACH=$1

echo "starting up again\n"
if [ "${DETACH}" = "-d" ]
then
    echo "detaching\n"
    docker-compose -f "./infra/compose.yaml" up -d
else
    docker-compose -f "./infra/compose.yaml" up
fi
