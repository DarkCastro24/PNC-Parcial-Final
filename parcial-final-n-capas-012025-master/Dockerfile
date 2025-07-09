# Usa una imagen de Java ligera
FROM eclipse-temurin:21-jre-alpine

# Crea el directorio de la app
WORKDIR /app

# Copia el JAR generado al contenedor
COPY target/parcial_final-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto donde corre la app (ajusta si cambiaste en application.properties)
EXPOSE 8190

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]