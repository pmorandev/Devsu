# Use a base image with Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY target/cliente-0.0.1-SNAPSHOT.jar /app/cliente-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "cliente-0.0.1-SNAPSHOT.jar"]
