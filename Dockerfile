FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/com.astontech.hr-1.0-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","/app.war"]