FROM dvmarques/openjdk-14-jdk-alpine-with-timezone

EXPOSE 8081

ADD target/conditional-0.0.1-SNAPSHOT.jar conditionalapp2.jar

ENTRYPOINT ["java", "-jar", "/conditionalapp2.jar"]