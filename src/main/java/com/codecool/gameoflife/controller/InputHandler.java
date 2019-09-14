package com.codecool.gameoflife.controller;

public interface InputHandler {
	void handleCellChange(int x, int y);

	void nextFrame();
}
