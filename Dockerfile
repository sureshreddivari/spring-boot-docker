# Use the official OpenJDK 8 base image
FROM openjdk:8-jdk-alpine

ADD target/docker-test.jar docker-test.jar

# Expose the port that the application will run on
EXPOSE 9090

# Command to run the application
ENTRYPOINT ["java", "-jar", "docker-test.jar"]