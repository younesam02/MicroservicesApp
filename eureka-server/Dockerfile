# eureka-server/Dockerfile
FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache wget
WORKDIR /app
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
