package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for(int n=0; n<3; n++)
            rows.add(new BoardRow());
    }

    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure){
        rows.get(row).getCols().set(col, figure);
    }

    public boolean checkWinInRows(Board board, Figure figure) {
        int row1;
        for (row1 = 0; row1 < 3; row1++) {
            boolean win = true;
            int col1;
            for (col1 = 0; col1 < 3; col1++) {
                if (getFigure(col1, row1) != figure) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinInCols(Board board, Figure figure) {
        int col2;
        for (col2 = 0; col2 < 3; col2++) {
            boolean win = true;
            int row2;
            for (row2 = 0; row2 < 3; row2++) {
                if (getFigure(col2, row2) != figure) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String s = "|-----------------|\n";
        for(BoardRow row:rows){
            s += "|     |     |     |\n";
            s += "|";
            for (Figure figure:row.getCols()){
                s += "  " + figure + "  |";
            }
            s += "\n|     |     |     |\n";
            s +=   "|-----------------|\n";
        }
        return s;
    }
}