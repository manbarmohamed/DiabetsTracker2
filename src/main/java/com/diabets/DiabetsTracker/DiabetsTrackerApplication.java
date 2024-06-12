package com.diabets.DiabetsTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan(value = "com")

public class DiabetsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiabetsTrackerApplication.class, args);
	}

}
