package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.view.Viewable;

public class SimpleInputHandler implements InputHandler {

	Strategy game;
	Viewable view;

	public SimpleInputHandler(Strategy game, Viewable view){
		this.game = game;
		this.view = view;
	}

	@Override
	public void handleCellChange(int x, int y) {
		game.getCurrentBoard().toggleField(y, x);
		view.printBoard(game.getCurrentBoard());
	}

	@Override
	public void nextFrame() {
		game.makeStep();
		view.printBoard(game.getCurrentBoard());
	}
}
