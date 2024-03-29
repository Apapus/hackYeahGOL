package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.InputHandler;
import com.codecool.gameoflife.model.Board;

public interface Viewable {

    public void printBoard(Board board);

    void registerInputHandler(InputHandler inputHandler);
}
