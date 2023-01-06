FROM openjdk:11-jdk

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# docker build -t apirest-app . --build-arg JAR_FILE=/target/apirest-1.0.0.jar

# docker run -d -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=apirest --name apirest-db -p 5432:5432 postgres:latest