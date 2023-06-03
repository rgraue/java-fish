# !/bin/bash

DETACH=$1

.scripts/kill.sh
.scripts/build-app-image.sh
.scripts/build-client-image.sh
.scripts/start.sh "${DETACH}"