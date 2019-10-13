FROM openjdk:8-jdk-alpine
ADD target/app-jar-with-dependencies.jar app.jar
EXPOSE 4567
CMD ["java","-jar", "app.jar"]

