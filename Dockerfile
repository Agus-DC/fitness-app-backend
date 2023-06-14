# Build stage

FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests


# Package stage

FROM adoptopenjdk:11-jdk-hotspot
COPY --from=build target/appconsultorio-0.0.1-SNAPSHOT.jar app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

