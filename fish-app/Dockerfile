FROM gradle:8.1.1-jdk11-alpine AS build

WORKDIR /home

COPY --chown=gradle:gradle . /home
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

EXPOSE 8080

RUN mkdir /app
COPY --from=build /home/build/libs/fishapp-0.0.1-SNAPSHOT.jar /home/app.jar
ENTRYPOINT [ "java", "-jar", "/home/app.jar" ]