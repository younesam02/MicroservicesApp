# microservice-commandes/Dockerfile
FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache wget
WORKDIR /app
# Change the JAR name to match your actual build artifact
COPY target/Microservice-commande-0.0.1-SNAPSHOT.jar Microservice-commande.jar

# Expose the port your app listens on (e.g., 8081)
EXPOSE 8081

ENTRYPOINT ["java","-jar","Microservice-commande.jar"]
