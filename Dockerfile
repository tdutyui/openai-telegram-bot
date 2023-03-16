FROM openjdk:19-jdk-alpine as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw -B package

FROM openjdk:19-jdk-alpine

COPY --from=build target/openai-telegram-bot-0.0.1-SNAPSHOT.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "openai-telegram-bot-0.0.1-SNAPSHOT.jar"]