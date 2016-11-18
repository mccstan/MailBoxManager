#!/bin/bash
cd mvnMailBoxManager
mvn clean
mvn package
asadmin start-domain domain1
asadmin start-database
asadmin deploy mvnMailBoxManager-ear/target/mvnMailBoxManager-ear-1.0.ear
cd ..
exec bash