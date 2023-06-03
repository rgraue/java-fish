# !/bin/bash

echo "buidling client images\n"
STARTTIME=$(date +%s)

cd "./fish-client/"

docker build -t "fish-client:latest" .

ENDTIME=$(date +%s)
DIF=$(($ENDTIME - $STARTTIME))

if [ $DIF -lt 1 ]
then
    DIF="< 1"
fi

cd "../"

echo "\n build time: ${DIF} seconds\n"