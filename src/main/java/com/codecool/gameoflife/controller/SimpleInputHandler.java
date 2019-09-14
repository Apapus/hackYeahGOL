package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.view.Viewable;

public class SimpleInputHandler implements InputHandler {

	private Strategy game;
	private Viewable view;

	public SimpleInputHandler(Strategy game, Viewable view){
		this.game = game;
		this.view = view;
	}

	@Override
	public void handleCellChange(int x, int y) {
		System.out.println("Change Cell requested");
		game.getCurrentBoard().toggleField(y, x);
		view.printBoard(game.getCurrentBoard());
	}

	@Override
	public void nextFrame() {
		System.out.println("Next frame requested");
		game.makeStep();
		view.printBoard(game.getCurrentBoard());
	}
}
