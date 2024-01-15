FROM eclipse-temurin:21.0.1_12-jre-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# docker run -p 8080:8080 --name springapp -d -t springbootapp:1.0
# docker build -t springbootapp:1.0 .