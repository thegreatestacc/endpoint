FROM openjdk:11
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]