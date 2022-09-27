package com.fbaa.learnspringframeworkweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringFrameworkWebApplication {

	public static void main(String[] args) {
		//manage components created
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnSpringFrameworkWebApplication.class, args);
	}

}
