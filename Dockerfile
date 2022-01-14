FROM openjdk:17
LABEL maintainer="gaurav"
ADD target/restapi-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
