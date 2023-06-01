# !/bin/bash

echo "shutting services down...\n"
docker-compose -f "./infra/compose.yaml" kill