#!/bin/bash
export JAVA_HOME=$(readlink -f /usr/bin/javac | sed "s:/bin/javac::")
export JAVA_OPTS="-Xms512M -Xmx1024M -XX:MaxPermSize=128M -server"
export M2_HOME='/opt/tools/maven/apache-maven-3.9.8'
nohup java -jar /home/ec2-user/server/currency-exchange-service-0.0.1-SNAPSHOT.jar >  /home/ec2-user/server/logs/log.txt 2>&1 &
echo $! > /home/ec2-user/server/pid.file