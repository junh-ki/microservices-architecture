# Start with a base image containing Java runtime
FROM openjdk:17-ea-17-slim as build

# Information around who maintains the image
MAINTAINER junh-ki

# Add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "/accounts-0.0.1-SNAPSHOT.jar"]
