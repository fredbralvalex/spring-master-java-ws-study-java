package com.fbaa.learnspringframework.game;

public class GameRunner {

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
