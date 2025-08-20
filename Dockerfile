FROM openjdk:17-jdk-slim

LABEL description="GFT Inditex Pricing Server"

WORKDIR /app

COPY target/pricing-server-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]