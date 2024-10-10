FROM openjdk:22
RUN mkdir -p /usr/src/workoutGenerator
COPY ./target/workoutGenerator-0.0.1-SNAPSHOT.jar /usr/src/workoutGenerator
WORKDIR /usr/src/workoutGenerator
EXPOSE 8082
CMD ["java", "-jar", "workoutGenerator-0.0.1-SNAPSHOT.jar"]


