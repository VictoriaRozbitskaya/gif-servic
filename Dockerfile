FROM gradle:7.2-jdk11
COPY ./build/libs/gif-service-0.1.jar gif-service-0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","gif-service-0.1.jar"]
