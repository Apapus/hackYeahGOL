package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.ConwaysGameOfLife;
import com.codecool.gameoflife.model.Board;
import com.codecool.gameoflife.model.Cell;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXView implements Viewable {

    private Stage primaryStage;
    Group root = new Group();

    private int cellHeight;
    private int cellWidth;

    private int height = 250;
    private int width = 300;

    private Paint alivePaint = Color.RED;
    private Paint deadPaint = Color.BLACK;

    private Rectangle[][] viewBoard;

    public JavaFXView(Stage stage, Board board) {
        primaryStage = stage;

        primaryStage.setTitle("Hello world");

        gameInit(board);

        Button btn = new Button();
        btn.setText("Start!");
        btn.setOnAction(event -> {
            System.out.println("Hello!");
            playGame();
        });

        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();

    }

    private void gameInit(Board board) {
        viewBoard = new Rectangle[board.getHeight()][board.getWidth()];
        cellHeight = height/board.getHeight();
        cellWidth = width/board.getWidth();
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                viewBoard[i][j] = new Rectangle(j*cellWidth, i*cellHeight,cellWidth, cellHeight);
                viewBoard[i][j].setFill(deadPaint);
            }
        }
    }

    private void playGame() {
//        Cell[][] board2 = new Cell[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if ((i == 2 && j > 0 && j < 4)) {
//                    board2[i][j] = new Cell(true);
//                } else {
//                    board2[i][j] = new Cell(false);
//                }
//            }
//        }
//        Viewable consoleView = new ConsoleView();
//        Board second = new Board(board2);
//        ConwaysGameOfLife gol = new ConwaysGameOfLife(second);
        for (Rectangle[] rectangleLine :
                viewBoard) {
            for (Rectangle rectangle :
                    rectangleLine) {
                root.getChildren().add(rectangle);
            }
        }
//        for (int i = 0; i < size; i++) {
//            consoleView.printBoard(gol.getCurrentBoard());
//            gol.makeStep();
//        }
    }

    @Override
    public void printBoard(Board board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                if (board.isCellAlive(i, j)){
                    System.out.println("i " + i + " j " + j);
                }
                viewBoard[i][j].setFill(board.isCellAlive(i, j) ? alivePaint : deadPaint);
            }
        }

    }
}
