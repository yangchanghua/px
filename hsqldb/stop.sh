#! /bin/bash
if [ ! -d "$HSQLDB_HOME" ]; then
echo "Set HSQLDB_HOME first."
exit 1
fi

HSQLDB_PID=`ps -ef | grep "lib/hsqldb.jar org.hsqldb.server.Server" | grep -v grep | awk '{print $2}'`
if [ "${HSQLDB_PID}" == "" ]; then 
echo "Not running."
exit 1
fi

kill $HSQLDB_PID
echo "Stopped."


