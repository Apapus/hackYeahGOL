package com.codecool.gameoflife;

import com.codecool.gameoflife.model.Board;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void create() {
        Board board = new Board(10, 10);
        // assertEquals(10, board.getWidth());
    }
}