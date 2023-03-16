FROM openjdk:19-jdk-alpine

WORKDIR /opt
COPY ./target /opt

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/openai-telegram-bot-0.0.1-SNAPSHOT.jar"]