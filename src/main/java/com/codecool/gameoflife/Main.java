package com.codecool.gameoflife;

import com.codecool.gameoflife.controller.ConwaysGameOfLife;
import com.codecool.gameoflife.controller.SimpleInputHandler;
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
        Viewable javaFxView = new JavaFXView(primaryStage, gol.getCurrentBoard());
        SimpleInputHandler inputHandler = new SimpleInputHandler(gol, javaFxView);
        javaFxView.registerInputHandler(inputHandler);
        javaFxView.printBoard(gol.getCurrentBoard());
    }
}
