FROM openjdk:8
EXPOSE 6000
ADD target/kafkaconsumer-0.0.1-SNAPSHOT.jar kafkaconsumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kafkaconsumer-0.0.1-SNAPSHOT.jar"]
