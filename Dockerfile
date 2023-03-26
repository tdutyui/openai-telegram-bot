FROM openjdk:19-jdk-alpine as build

ARG bot_token
ENV BOT_TOKEN=$bot_token

ARG bot_username
ENV BOT_USERNAME=$bot_username

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN ./mvnw -B package

FROM openjdk:19-jdk-alpine

COPY --from=build target/openai-telegram-bot-0.0.1-SNAPSHOT.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "openai-telegram-bot-0.0.1-SNAPSHOT.jar"]