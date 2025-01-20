# gateway/Dockerfile
FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache wget
WORKDIR /app
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway.jar"]
