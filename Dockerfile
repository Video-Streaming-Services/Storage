FROM openjdk:8
EXPOSE 8060
ADD target/Storage.jar Storage.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","Storage.jar"]
