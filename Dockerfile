FROM openjdk:17-jdk-alpine
MAINTAINER amithdarshana@gmail.com

RUN mvn clean install

COPY target/article_service-0.0.1-SNAPSHOT.jar article_service.jar
ENTRYPOINT ["java","-jar","/article_service.jar"]