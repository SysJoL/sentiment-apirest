# Etapa 1: Compilación (Usamos Maven con JDK 17)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiamos el archivo de configuración de dependencias
COPY pom.xml .
# Descargamos las dependencias
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos el JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Cambiamos openjdk por eclipse-temurin para evitar errores)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiamos el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto que usará Spring Boot
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]