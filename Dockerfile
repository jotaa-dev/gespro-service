# Use Amazon Corretto JDK 17 with Alpine as the base image
FROM --platform=linux/amd64 amazoncorretto:17-alpine

# Set the working directory in the container
WORKDIR /app

# Define a build argument to specify the JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file to the image
COPY ${JAR_FILE} /app/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]