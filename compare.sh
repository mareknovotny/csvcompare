#!/bin/sh
#
#
# $1 - original file
# $2 - new file
#

java -jar target/csvcompare-0.0.1-SNAPSHOT.jar -o $1 -n $2 -d ,
