FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src src
RUN mvn -B -DskipTests package

FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:latest
WORKDIR /deployments

COPY --from=build /workspace/target/jenkins-learning-1.0.0.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]