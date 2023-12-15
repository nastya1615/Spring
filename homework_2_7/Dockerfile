FROM openjdk:17-oracle

WORKDIR /app

COPY target/homework_2_7-0.0.1-SNAPSHOT.jar app.jar

ENV SWITCHABLE_LISTENER=true

CMD ["java", "-jar", "app.jar"]