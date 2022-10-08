# mvn clean package spring-boot:repackage
# docker build -t name-image .
# docker run -it -p 8080:8080 name-image 
FROM openjdk:11-jre-slim
WORKDIR /usr/src/myapp
COPY target/jwt-0.0.1-SNAPSHOT.jar /usr/src/myapp/app.jar
EXPOSE 8080
CMD [ "java", "-jar", "/usr/src/myapp/app.jar" ]