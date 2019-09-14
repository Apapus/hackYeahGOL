package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.model.Board;

public class ConwaysGameOfLife implements Strategy{

    private static final int MINIMAL_LIVE_NEIGHBOURS = 2;
    private static final int MAXIMUM_LIVE_NEIGHBOURS = 3;
    private static final int NUMBER_OF_REPRODUCING_MEMBERS = 3;

    private Board currentBoard;

    public ConwaysGameOfLife(Board board) {
        this.currentBoard = board;
    }

    @Override
    public boolean shouldBeAliveNextRound(int row, int column) {
        //Implement method that checks if that cell should be alive in next turn.
        //Return true or false
        return false;
    }

    @Override
    public void makeStep() {
        //Implement method that generates next board.
    }

    @Override
    public Board getCurrentBoard(){
        return currentBoard;
    }

}
