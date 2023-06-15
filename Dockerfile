FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target/achat-1.0.jar .

EXPOSE 8089

# Run the Spring Boot application
CMD ["java", "-jar", "achat-1.0.jar"]