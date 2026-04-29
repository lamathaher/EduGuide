package com.lama.roadmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 

public class RoadmapBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoadmapBackendApplication.class, args);
		
	}

	
}

