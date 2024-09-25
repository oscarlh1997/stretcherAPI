# Usa una imagen base de Java
FROM openjdk:23

COPY target/SpringBootCRUD-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]