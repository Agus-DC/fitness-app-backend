# Utiliza la imagen base de Java
FROM openjdk:11-jdk

# Copia el código fuente a la imagen
COPY . /app

# Establece el directorio de trabajo
WORKDIR /app

# Compila la aplicación
RUN ./gradlew build

# Expone el puerto en el que se ejecuta tu aplicación
EXPOSE 8080

# Ejecuta la aplicación
CMD ["./gradlew", "bootRun"]
