FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} guess-number.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/guess-number.jar"]