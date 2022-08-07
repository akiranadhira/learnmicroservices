FROM openjdk:8-slim as build

MAINTAINER akiranadhira

COPY target/accountservice-0.0.1-SNAPSHOT.jar accountservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/accountservice-0.0.1-SNAPSHOT.jar"]
