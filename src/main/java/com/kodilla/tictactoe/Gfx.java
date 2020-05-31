package com.kodilla.tictactoe;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Gfx {
    private Image imageX = new Image("file:src/main/resources/x.png");
    private Image imageO = new Image("file:src/main/resources/o.png");
    private GridPane gridPane;
    private Board board;
    private Stage stage;
    private boolean xHasMove = true;

    public Gfx(GridPane grid, Board board, Stage stage) {
        gridPane = grid;
        this.board = board;
        this.stage = stage;
    }

    public void doMove(int x, int y) {
        if (board.getFigure(x, y) instanceof Empty) {
            Figure figure = xHasMove ? new X() : new O();
            board.setFigure(x, y, figure);
            xHasMove = !xHasMove;
            displaylOnGrid();
            if (board.isWinner()) {
                displayPopUp(" Winner!");
                System.out.println("Winner");
                board.initBoard();
                displaylOnGrid();
            } else if (board.isBoardFull()){
                displayPopUp(" Draw!");
                System.out.println("Draw");
                board.initBoard();
                displaylOnGrid();
            }
        }
    }

    private void displayPopUp(String text) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);
        Text text1 = new Text(text);
        text1.setFont(new Font(30));
        dialogVbox.getChildren().add(text1);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

    }

    private void displaylOnGrid() {
        gridPane.getChildren().clear();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Figure figure = board.getFigure(col, row);
                ImageView imageView = null;
                if (figure instanceof O)
                    imageView = new ImageView(imageO);
                else if (figure instanceof X)
                    imageView = new ImageView(imageX);
                if (imageView != null)
                    gridPane.add(imageView, col, row);
            }
        }
    }
}