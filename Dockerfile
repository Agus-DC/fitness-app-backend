# Use an official OpenJDK runtime as the base image
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory in the container
WORKDIR /opt/render/fitness-app-backend/

# Copy the pom.xml file to the container
COPY pom.xml .

# Copy the entire project to the container
COPY . .

# Build the application with Maven
RUN ./mvnw package -DskipTests

# Set the command to run the application
CMD ["java", "-jar", "target/appconsultorio-0.0.1-SNAPSHOT.jar"]
