FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/Stage_EX1-0.0.1-SNAPSHOT.jar Stage_EX1-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/Stage_EX1-0.0.1-SNAPSHOT.jar"]