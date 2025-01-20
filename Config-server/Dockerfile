# config-server/Dockerfile
FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache wget
WORKDIR /app
COPY target/Config-server-0.0.1-SNAPSHOT.jar Config-server.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "Config-server.jar"]
