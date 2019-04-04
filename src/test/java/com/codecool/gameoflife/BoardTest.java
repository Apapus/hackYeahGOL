package com.codecool.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void create() {
        Board board = new Board(10, 10);
        // assertEquals(10, board.getWidth());
    }
}