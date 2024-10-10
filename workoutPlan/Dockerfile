FROM openjdk:22
RUN mkdir -p /usr/src/workoutPlan
COPY ./target/workoutPlan-0.0.1-SNAPSHOT.jar /usr/src/workoutPlan
WORKDIR /usr/src/workoutPlan
EXPOSE 8082
CMD ["java", "-jar", "workoutPlan-0.0.1-SNAPSHOT.jar"]


