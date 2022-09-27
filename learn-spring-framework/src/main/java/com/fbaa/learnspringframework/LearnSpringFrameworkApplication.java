package com.fbaa.learnspringframework;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fbaa.learnspringframework.game.GameRunner;
import com.fbaa.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
//		GameConsole game = new MarioGame();
		SuperContraGame game = new SuperContraGame();
		GameRunner runner = new GameRunner(game);
		
		runner.runGame();
	}

}
