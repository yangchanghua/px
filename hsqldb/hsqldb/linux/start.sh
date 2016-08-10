#! /bin/bash
if [ ! -d "$HSQLDB_HOME" ];  then
echo "Set HSQLDB_HOME first."
exit 1
fi

if [ ! -f "$HSQLDB_HOME/lib/hsqldb.jar" ]; then
echo "$HSQLDB_HOME/lib/hsqldb.jar doesn't exist."
exit 1
fi

DB_FILE_NAME=df_db_file
SERVER_ARGS="--database.0 file:$DB_FILE_NAME --dbname.0 df_database --silent false"
java -cp $HSQLDB_HOME/lib/hsqldb.jar org.hsqldb.server.Server $SERVER_ARGS  > /dev/null 2>&1 &
echo "Started in background, stop it using stop.sh"

