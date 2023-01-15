FROM openjdk:17-jdk-alpine
MAINTAINER amithdarshana@gmail.com
COPY target/article_service-0.0.1-SNAPSHOT-stubs.jar
ENTRYPOINT ["java","-jar","/article_service-0.0.1-SNAPSHOT-stubs.jar"]