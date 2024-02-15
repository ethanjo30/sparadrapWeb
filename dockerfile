FROM openjdk-17

COPY target/sapradrapWeb-0.0.1-SNAPSHOT.jar sapradrapWeb-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "sapradrapWeb-0.0.1-SNAPSHOT.jar"]