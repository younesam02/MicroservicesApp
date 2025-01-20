# microservice-produit/Dockerfile
FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache wget
WORKDIR /app
COPY target/Produit-0.0.1-SNAPSHOT.jar Produit.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "Produit.jar"]
