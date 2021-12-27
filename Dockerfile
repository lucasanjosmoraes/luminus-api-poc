FROM openjdk:8-alpine

COPY target/uberjar/luminus-api-poc.jar /luminus-api-poc/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luminus-api-poc/app.jar"]
