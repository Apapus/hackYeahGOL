package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.model.Board;

public interface Strategy {
    boolean shouldBeAliveNextRound(int row, int column);
    void makeStep();
    Board getCurrentBoard();
}
