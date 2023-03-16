FROM openjdk:19-jdk-alpine

WORKDIR . /app

RUN ./mvnw -B package

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/openai-telegram-bot-0.0.1-SNAPSHOT.jar"]