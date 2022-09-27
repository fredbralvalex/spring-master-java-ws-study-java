package com.fbaa.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	@Autowired
	private GameConsole game;
	
	public GameRunner (GameConsole game) {
		this.game = game;
	}
	
//  set injection	
//	@Autowired
//	public void setGame(GameConsole game) {
//		this.game = game;
//	}
	
	public void runGame() {
		game.up();
		game.down();		
		game.left();
		game.right();
	}

	
}
