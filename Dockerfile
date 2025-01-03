FROM openjdk:17-jdk-slim
COPY target/todo-app-0.0.1-SNAPSHOT.jar todo-app.jar
ENTRYPOINT ["java", "-jar", "/todo-app.jar"]
EXPOSE 8080