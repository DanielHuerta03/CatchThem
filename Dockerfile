FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/CatchThem-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} CatchThem.jar
ENTRYPOINT ["java","-jar","/CatchThem.jar"]