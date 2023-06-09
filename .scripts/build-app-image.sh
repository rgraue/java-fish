# !/bin/bash
echo "buidling app images\n"
STARTTIME=$(date +%s)

cd "./fish-app/"

docker build -t "fish-app:latest" .

ENDTIME=$(date +%s)
DIF=$(($ENDTIME - $STARTTIME))

if [ $DIF -lt 1 ]
then
    DIF="< 1"
fi

cd "../"

echo "\n build time: ${DIF} seconds\n"
