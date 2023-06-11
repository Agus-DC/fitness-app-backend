# Use an official OpenJDK runtime as the base image
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Copy the entire project to the container
COPY . .

# Build the application with Maven
RUN ./mvnw package -DskipTests

ENV DB_HOST dpg-ci33js3hp8u1a1dppad0-a
ENV DB_PORT 5432
ENV DB_NAME mydatabase_yeib
ENV DB_USER myuser
ENV DB_PASSWORD zS3aWuO7ywYHrFHGtjfvathKZCdOCOmW

# Set the command to run the application
CMD ["java", "-jar", "target/appconsultorio-0.0.1-SNAPSHOT.jar"]
