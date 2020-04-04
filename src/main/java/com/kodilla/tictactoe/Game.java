package com.kodilla.tictactoe;

import java.util.Scanner;

public class Game {
    private Board board = new Board();

    public void play() {

        System.out.println("Witaj w grze \"Kółko i krzyżyk\"");

        for (int i = 0; i < 5; i++) {

            System.out.println("Podaj numer wiersza i kolumny do wstawienia: \"X\"");
            System.out.println("Kolumna nr: ");
            int col1 = new Scanner(System.in).nextInt() - 1;
            System.out.println("Wiersz nr: ");
            int row1 = new Scanner(System.in).nextInt() - 1;
            if (board.getFigure(col1, row1) == null) {
                board.setFigure(col1, row1, new X());
            } else {
                System.out.println("Niedozwolony ruch / Pole zajęte / Zacznij od początku");
                break;
            }
            System.out.println(board);

            System.out.println("Podaj numer wiersza i kolumny do wstawienia: \"O\"");
            System.out.println("Kolumna nr: ");
            int col2 = new Scanner(System.in).nextInt() - 1;
            System.out.println("Wiersz nr: ");
            int row2 = new Scanner(System.in).nextInt() - 1;
            if (board.getFigure(col2, row2) == null) {
                board.setFigure(col2, row2, new O());
            } else {
                System.out.println("Niedozwolony ruch / Pole zajęte / Zacznij od początku");
                break;
            }
            System.out.println(board);
        }
    }
}