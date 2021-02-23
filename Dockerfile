# Start with a base image containing Java runtime
FROM openjdk:latest
EXPOSE 8082
WORKDIR /app
COPY target/covidapp-0.0.1-SNAPSHOT.jar target/covidapp-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","target/covidapp-0.0.1-SNAPSHOT.jar"]