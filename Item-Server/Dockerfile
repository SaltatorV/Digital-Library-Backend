FROM openjdk:17.0.2-jdk-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=../jars/spring-boot-docker.jar
ADD ${JAR_FILE} Item-Server.jar
ENTRYPOINT ["java","-jar","/Item-Server.jar"]