package com.codecool.gameoflife.model;

public class Cell {

    private boolean alive;

    Cell(){
        alive = false;
    }

    public Cell(boolean alive){
        this.alive = alive;
    }

    boolean isAlive() {
        return alive;
    }

    void toggle() {
        this.alive = !this.alive;
    }

    @Override
    public String toString() {
        return alive ? "*" : "-";
    }
}
