FROM dvmarques/openjdk-14-jdk-alpine-with-timezone

ADD target/authorization-0.0.1-SNAPSHOT.jar authorization.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "/authorization.jar"]