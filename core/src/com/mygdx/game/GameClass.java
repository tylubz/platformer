package com.mygdx.game;

import Screens.GameScreen;

import com.badlogic.gdx.Game;

public class GameClass extends Game {
	
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
	

}


