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

    public Board(Cell[][] board) {
        this.board = new Cell[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                this.board[i][j] = new Cell(board[i][j].isAlive());
            }
        }
    }

    public int getNumberOfAliveNeighbours(int x, int y) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    if (x + i >= 0 && x + i < board.length &&
                            y + j >= 0 && y + j < board[0].length)
                        if (board[x + i][y + j].isAlive()) {
                            counter++;
                        }
                }
            }
        }
        return counter;
    }

    public void toggleField(int row, int column) {
        if (row < board.length && row > 0 && column < board[row].length) {
            this.board[row][column].toggle();
        }
    }

    public boolean isCellAlive(int row, int column) {
        if (row < board.length && row > 0 && column < board[row].length) {
            return this.board[row][column].isAlive();
        }
        return false;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell[] cells : board) {
            for (int j = 0; j < board[0].length; j++) {
                builder.append(cells[j].toString());
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
