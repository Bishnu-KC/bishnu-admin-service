FROM openjdk:latest

MAINTAINER Bishnu K C "contact@programmers.com"

EXPOSE 8080

WORKDIR /usr/local/bin/

COPY ./target/bishnu-admin-service-0.0.1.jar bishnuservice.jar

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "bishnuservice.jar"]