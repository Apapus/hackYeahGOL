package com.codecool.gameoflife.model;

public class Board {

    private Cell[][] board;

    public Board(int height, int width) {
        this.board = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    public int getNumberOfAliveNeighbours(int x, int y) {
        return 0;
    }

    public void toggleField(int row, int column) {
            this.board[row][column].toggle();
    }

    public boolean isCellAlive(int row, int column) {
            return this.board[row][column].isAlive();
    }

    public int getHeight() {
        return board.length;
    }

    public int getWidth() {
        return board.length > 0 ? board[0].length : -1;
    }

    public Cell[][] getBoard() {
        return board;
    }
}
