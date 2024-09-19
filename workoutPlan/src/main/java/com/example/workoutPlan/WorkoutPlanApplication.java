package com.example.workoutPlan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkoutPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutPlanApplication.class, args);
	}

}
