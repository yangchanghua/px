#!/bin/bash

case $1 in
    on)
        hsqldb/start.sh
        ;;
    off)
        hsqldb/stop.sh
        ;;
    restart)
        hsqldb/stop.sh
        hsqldb/start.sh
        ;;
    *)
        echo "unknown command"
        ;;
esac
