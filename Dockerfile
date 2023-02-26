FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/Stage_EX1-1.0.0.jar Stage_EX1-1.0.0.jar

CMD ["java", "-jar", "/Stage_EX1-1.0.0.jar"]