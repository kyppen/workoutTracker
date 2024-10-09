FROM openjdk:22
COPY ./target/workoutGenerator-0.0.1-SNAPSHOT.jar /usr/src/workoutgenerator
WORKDIR /usr/src/workoutGenerator
EXPOSE 8082
CMD ["java", "-jar", "workoutGenerator-0.0.1-SNAPSHOT.jar"]


