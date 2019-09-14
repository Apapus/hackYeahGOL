package com.codecool.gameoflife.view;

import com.codecool.gameoflife.model.Board;

public class ConsoleView implements Viewable {
    @Override
    public void printBoard(Board board) {
        System.out.println(board.toString());
    }
}
