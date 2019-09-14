package com.codecool.gameoflife.controller;

public interface Strategy {
    boolean shouldBeAliveNextRound(int row, int column);
    void makeStep();
}
