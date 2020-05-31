package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        initBoard();
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    public boolean isWinner() {
        return checkWinInRows() || checkWinInCols() || checkWinInDiagonals();
    }

    public boolean isBoardFull() {
        boolean result = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (getFigure(col, row) instanceof Empty)
                    result = false;
            }
        }
        return result;
    }

    private boolean checkWinInDiagonals() {
        boolean result = isFirstDiagonalX();
        result = result || isSecondDiagonalX();
        result = result || isFirstDiagonalO();
        result = result || isSecondDiagonalO();
        return result;
    }

    private boolean isSecondDiagonalO() {
        boolean result = true;
        for (int n = 0; n < 3; n++) {
            if (!(getFigure(2 - n, 2 - n) instanceof O)) result = false;
        }
        return result;
    }

    private boolean isFirstDiagonalO() {
        boolean result = true;
        for (int n = 0; n < 3; n++) {
            if (!(getFigure(n, n) instanceof O)) result = false;
        }
        return result;
    }

    private boolean isSecondDiagonalX() {
        boolean result = true;
        for (int n = 0; n < 3; n++) {
            if (!(getFigure(2 - n, 2 - n) instanceof X)) result = false;
        }
        return result;
    }

    private boolean isFirstDiagonalX() {
        boolean result = true;
        for (int n = 0; n < 3; n++) {
            if (!(getFigure(n, n) instanceof X)) result = false;
        }
        return result;
    }

    private boolean checkWinInRows() {
        boolean result = false;
        for (int row = 0; row < 3; row++) {
            result = result || allInRow(row);
        }
        return result;
    }

    private boolean allInRow(int row) {
        return
                (getFigure(0, row) instanceof O &&
                        getFigure(1, row) instanceof O &&
                        getFigure(2, row) instanceof O) ||
                        (getFigure(0, row) instanceof X &&
                                getFigure(1, row) instanceof X &&
                                getFigure(2, row) instanceof X);
    }

    private boolean checkWinInCols() {
        boolean result = false;
        for (int col = 0; col < 3; col++) {
            result = result || allInCol(col);
        }
        return result;
    }

    private boolean allInCol(int col) {
        return
                (getFigure(col, 0) instanceof O &&
                        getFigure(col, 1) instanceof O &&
                        getFigure(col, 2) instanceof O) ||
                        (getFigure(col, 0) instanceof X &&
                                getFigure(col, 1) instanceof X &&
                                getFigure(col, 2) instanceof X);
    }

    @Override
    public String toString() {
        String s = "|-----------------|\n";
        for (BoardRow row : rows) {
            s += "|     |     |     |\n";
            s += "|";
            for (Figure figure : row.getCols()) {
                s += "  " + figure + "  |";
            }
            s += "\n|     |     |     |\n";
            s += "|-----------------|\n";
        }
        return s;
    }

    public void initBoard() {
        rows.clear();
        for (int n = 0; n < 3; n++)
            rows.add(new BoardRow());
    }
}