FROM openjdk:8-jre-alpine

COPY /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

ENV LANG en_GB.UTF-8

ENV JAVA_OPTS="-Xms512m -Xmx2048m"

ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8090