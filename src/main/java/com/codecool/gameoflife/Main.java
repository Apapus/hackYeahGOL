package com.codecool.gameoflife;

import com.codecool.gameoflife.controller.ConwaysGameOfLife;
import com.codecool.gameoflife.model.Board;
import com.codecool.gameoflife.view.JavaFXView;
import com.codecool.gameoflife.view.Viewable;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Board board = new Board(10,10);
        ConwaysGameOfLife gol = new ConwaysGameOfLife(board);
        gol.getCurrentBoard().toggleField(1,1);
        gol.getCurrentBoard().toggleField(1,2);
        gol.getCurrentBoard().toggleField(1,3);
        System.out.println(gol.getCurrentBoard());
        Viewable javaFxView = new JavaFXView(primaryStage, gol.getCurrentBoard());
        javaFxView.printBoard(gol.getCurrentBoard());
    }
}
