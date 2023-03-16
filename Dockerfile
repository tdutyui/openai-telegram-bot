FROM openjdk:19-jdk-alpine

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/runner/work/openai-telegram-bot/openai-telegram-bot/openai-telegram-bot-0.0.1-SNAPSHOT.jar"]