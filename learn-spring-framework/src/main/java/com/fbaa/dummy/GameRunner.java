package com.fbaa.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fbaa.learnspringframework.game.GameConsole;

@Component
public class GameRunner {

	@Autowired
	private GameConsole game;
	
	public GameRunner (GameConsole game) {
		this.game = game;
	}
	
	public void runGame() {
		game.up();
		game.down();		
		game.left();
		game.right();
	}
	
}
