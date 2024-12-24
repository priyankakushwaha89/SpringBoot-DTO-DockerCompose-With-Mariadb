FROM openjdk:17

ADD target/Bookapptest.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]