FROM openjdk:19-jdk-alpine

COPY . /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/src/openai-telegram-bot-0.0.1-SNAPSHOT.jar"]