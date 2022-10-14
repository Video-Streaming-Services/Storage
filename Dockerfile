FROM openjdk:8
EXPOSE 8060
ADD target/Storage.jar Storage.jar
ENTRYPOINT ["java","-jar","Storage.jar"]
