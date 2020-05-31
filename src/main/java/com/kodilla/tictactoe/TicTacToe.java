package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    private Image imageback = new Image("file:src/main/resources/background.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);
        grid.setGridLinesVisible(false);

        for (int n = 0; n < 3; n++) {
            grid.getColumnConstraints().add(new ColumnConstraints(300));
            grid.getRowConstraints().add(new RowConstraints(200));
        }

        Board board = new Board();
        Gfx gfx = new Gfx(grid, board, primaryStage);
        grid.setOnMouseClicked(e -> {
            System.out.println(e.getX() + "," + e.getY());
            int x = ((int) e.getX()-350) / 295;
            int y = ((int) e.getY()-145) / 198;
            System.out.println(x + "," + y);
            gfx.doMove(x, y);
        });

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}