# ---- BUILD STAGE ----
FROM openjdk:17-alpine AS builder

WORKDIR /app

# Copy pom.xml and Maven wrapper
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

# Preload dependencies (faster builds)
RUN ./mvnw dependency:go-offline

# Copy full source code
COPY src src

# Build the Spring Boot executable jar
RUN ./mvnw clean package -DskipTests

# ---- RUNTIME STAGE ----
FROM openjdk:17-alpine

WORKDIR /app

# Copy the executable jar
COPY --from=builder /app/target/SpringSecurity-0.0.1-SNAPSHOT.jar .

# Expose the port
EXPOSE 8001

# Run the app
CMD ["java", "-jar", "SpringSecurity-0.0.1-SNAPSHOT.jar"]
    