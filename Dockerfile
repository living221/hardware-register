FROM amazoncorretto:8-alpine-jdk
COPY target/*.jar server.jar
ENTRYPOINT ["java","-jar","/server.jar"]