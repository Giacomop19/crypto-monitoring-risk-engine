FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests

# Run jar
CMD ["java", "-jar", "target/crypto-transaction-monitoring-0.0.1-SNAPSHOT.jar"]