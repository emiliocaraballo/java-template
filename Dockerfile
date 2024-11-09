FROM openjdk:17-alpine
MAINTAINER Img
ENV TZ="America/Bogota"
ADD target/*.jar micro.jar
ENTRYPOINT ["java", "-jar", "micro.jar"]
# ENTRYPOINT ["java","-Dspring.profiles.active=<PROFILE>", "-jar", "micro.jar"]
