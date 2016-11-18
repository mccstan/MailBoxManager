#!/bin/bash
asadmin undeploy mvnMailBoxManager-ear/target/mvnMailBoxManager-ear-1.0
asadmin stop-domain domain1
asadmin stop-database
exec bash