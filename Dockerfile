FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY build/libs/* build/lib/

COPY build/libs/hero-1.0-SNAPSHOT.jar build/

WORKDIR /app/build
ENTRYPOINT java -jar hero-1.0-SNAPSHOT.jar