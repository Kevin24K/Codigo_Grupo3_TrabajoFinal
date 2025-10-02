# Etapa de compilación
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY Trabajo_Grupo3/pom.xml .
COPY Trabajo_Grupo3/src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]