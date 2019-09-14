package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.InputHandler;
import com.codecool.gameoflife.model.Board;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXView implements Viewable {

    private Group root = new Group();

    private int cellHeight;
    private int cellWidth;

    private int height = 250;
    private int width = 300;

    private Paint alivePaint = Color.RED;
    private Paint deadPaint = Color.BLACK;

    private Rectangle[][] viewBoard;

    private InputHandler inputHandler;

    public JavaFXView(Stage stage, Board board) {
        gameInit(board);

        Button btn = new Button();
        btn.setText("Start!");
        btn.setOnAction(event -> {
            System.out.println("Hello!");
            addRectanglesToView();
        });

        root.getChildren().add(btn);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        root.setOnMouseReleased(this::handleMouseInput);
        root.setOnKeyReleased(this::handleKeyInput);

    }

    private void handleKeyInput(KeyEvent event) {
        if (event.getCode().equals(KeyCode.RIGHT)){
            inputHandler.nextFrame();
        }
    }

    private void handleMouseInput(MouseEvent event) {
        if (inputHandler != null){
            if (event.getTarget() instanceof Rectangle){
                Rectangle targetRectangle = (Rectangle) event.getTarget();
                int x_target = (int) targetRectangle.getX() / cellWidth;
                int y_target = (int) targetRectangle.getY() / cellHeight;
                inputHandler.handleCellChange(x_target, y_target);
            }
        }
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

    private void addRectanglesToView() {
        for (Rectangle[] rectangleLine :
                viewBoard) {
            for (Rectangle rectangle :
                    rectangleLine) {
                root.getChildren().add(rectangle);
            }
        }
    }

    @Override
    public void printBoard(Board board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                viewBoard[i][j].setFill(board.isCellAlive(i, j) ? alivePaint : deadPaint);
            }
        }
    }

    @Override
    public void registerInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
}
