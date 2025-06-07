# Étape 1 - build de l'app
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 - image finale
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose le port (important pour Railway)
EXPOSE 8080

# Lance l'app
ENTRYPOINT ["java", "-jar", "app.jar"]
