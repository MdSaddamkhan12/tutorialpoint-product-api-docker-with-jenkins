FROM openjdk:11
EXPOSE 8085
ADD target/spring-crud-docker.jar spring-crud-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-crud-docker.jar"]
