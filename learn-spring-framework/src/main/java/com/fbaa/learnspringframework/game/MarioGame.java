package com.fbaa.learnspringframework.game;

public class MarioGame implements GameConsole {

	@Override
	public void up() {
		System.out.println("jump");
	}

	@Override
	public void down() {
		System.out.println("fo into a hole");
	}
	
	@Override
	public void left() {
		System.out.println("stop");
	}
	
	@Override
	public void right() {
		System.out.println("go faster");
	}
	
	
}
