FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/showroom-0.0.1-SNAPSHOT.jar /app/showroom-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "showroom-0.0.1-SNAPSHOT.jar"]

