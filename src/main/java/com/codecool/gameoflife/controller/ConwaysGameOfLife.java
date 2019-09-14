package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.model.Board;

/**
 * This is an implemented strategy to Conway's Game of Life:
 * The rules are as follows:
 * If a Cell is dead and has exactly 3 alive neighbours it comes alive
 * If a Cell is alive and has LESS THAN 2 live neighbours or has MORE THAN 3 live neighbours, it dies.
 */
public class ConwaysGameOfLife implements Strategy{

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
