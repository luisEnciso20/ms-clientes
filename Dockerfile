# 🛠️ ETAPA 1: CONSTRUCCIÓN (Builder Stage)
# Usamos una imagen que tiene Maven y JDK 17 preinstalados
FROM maven:3.9-eclipse-temurin-17 AS builder

# Creamos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el código fuente (el contexto de tu proyecto)
COPY . /app

# Compilamos el proyecto con Maven para generar el archivo JAR
# El JAR generado estará en /app/target/ms-clientes-0.0.1-SNAPSHOT.jar
RUN mvn clean package -DskipTests


# 🚀 ETAPA 2: EJECUCIÓN (Runtime Stage)
# Usamos solo el Entorno de Ejecución (JRE) de Java 17, que es mucho más ligero
FROM eclipse-temurin:17-jre

# Establecemos el directorio de trabajo final
WORKDIR /

# Argumento para el nombre del JAR (ajustado al nombre que usa tu proyecto)
ARG JAR_FILE=/app/target/ms-clientes-0.0.1-SNAPSHOT.jar

# Copiamos SOLAMENTE el archivo JAR compilado desde la etapa "builder"
COPY --from=builder ${JAR_FILE} app.jar

# Spring Boot usa el puerto 8080 por defecto
EXPOSE 8080

# Definimos el comando que se ejecuta al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "/app.jar"]