FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/miniproj-1.0.0.jar miniproj-1.0.0.jar

CMD ["java", "-jar", "/miniproj-1.0.0.jar"]