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
        int neighbours = currentBoard.getNumberOfAliveNeighbours(row, column);
        if (currentBoard.isCellAlive(row, column)) {
            if (neighbours < MINIMAL_LIVE_NEIGHBOURS || neighbours > MAXIMUM_LIVE_NEIGHBOURS) {
                return false;
            }
        } else {
            if (neighbours == NUMBER_OF_REPRODUCING_MEMBERS) {
                return true;
            }
        }

        return currentBoard.isCellAlive(row, column);
    }

    @Override
    public void makeStep() {
        Board nextBoard = new Board(currentBoard.getBoard());
        for (int i = 0; i < currentBoard.getHeight(); i++) {
            for (int j = 0; j < currentBoard.getWidth(); j++) {
                if (currentBoard.isCellAlive(i, j) ^ shouldBeAliveNextRound(i, j)) {
                    nextBoard.toggleField(i, j);
                }
            }
        }
        currentBoard = nextBoard;
    }

    @Override
    public Board getCurrentBoard(){
        return currentBoard;
    }

}
