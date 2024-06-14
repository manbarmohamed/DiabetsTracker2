package com.diabets.DiabetsTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@SpringBootApplication
public class DiabetsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiabetsTrackerApplication.class, args);
	}

}
