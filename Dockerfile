# Usar una imagen base con Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/order-products-0.0.1-SNAPSHOT.jar order-prducts.jar

# Exponer el puerto del microservicio
EXPOSE 8080

# Definir el comando para ejecutar el servicio
ENTRYPOINT ["java", "-jar", "my-microservice.jar"]