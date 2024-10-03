FROM openjdk:17-jdk-slim

WORKDIR /app
COPY /build/libs/homework.jar /app/homework.jar

ENTRYPOINT ["java", "-jar", "/app/homework.jar"]