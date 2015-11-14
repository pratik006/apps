mvn clean install -f ../blog

mvn clean install
rm -rf ~/Java/apache-tomcat-8.0.28/webapps/app.war
mv target/app-core-0.0.1-SNAPSHOT.war ~/Java/apache-tomcat-8.0.28/webapps/app.war
sh ~/Java/apache-tomcat-8.0.28/bin/catalina.sh run