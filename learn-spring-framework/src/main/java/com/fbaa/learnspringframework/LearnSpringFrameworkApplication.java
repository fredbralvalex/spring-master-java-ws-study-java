package com.fbaa.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fbaa.learnspringframework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
		//manage components created
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//MarioGame, GameRunner
		GameRunner runner = context.getBean(GameRunner.class);
		
//		GameConsole game = new MarioGame();
//		SuperContraGame game = new SuperContraGame();
//		GameRunner runner = new GameRunner(game);
		
		runner.runGame();
	}

}
