package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        var q = new NQueens();
        List<List<String>> anss = q.solveNQueens(4);

        assert ".Q..".equals(anss.get(0).get(0));
        assert "...Q".equals(anss.get(0).get(1));
        assert "Q...".equals(anss.get(0).get(2));
        assert "..Q.".equals(anss.get(0).get(3));

        assert "..Q.".equals(anss.get(1).get(0));
        assert "Q...".equals(anss.get(1).get(1));
        assert "...Q".equals(anss.get(1).get(2));
        assert ".Q..".equals(anss.get(1).get(3));

        System.out.println("tests passed");
    }

    public int[][] board;
    public List<List<String>> out = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.board = buildBoard(n);
        backtrack(0);
        return out;
    }

    public List<String> saveSolution() {
        var list = new ArrayList<String>();
        for (int row = 0; row < board.length; row++) {
            var s = new StringBuilder();
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 0) s.append(".");
                else s.append("Q");
            }
            list.add(s.toString());
        }
        return list;
    }

    public void backtrack(int row) {
        for (int col = 0; col < this.board.length; col++) {
            // if queen does not attack other ones
            if (!queenAttacksSomeone(row, col)) {
                // place this queen on the board
                placeQueen(row, col);
                // if it was the edge of the board so save queens locations on the board
                if (row + 1 == board.length) {
                    List<String> sol = saveSolution();
                    out.add(sol);
                }
                // else try to place next queen on the board
                else backtrack(row + 1);
                removeQueen(row, col);
            }
        }
    }

    public void placeQueen(int r, int c) {
        board[r][c] = 1;
    }
    public void removeQueen(int r, int c) {
        board[r][c] = 0;
    }

    public boolean queenAttacksSomeone(int r, int c) {
        // row
        for (int i = c + 1; i < board.length; i++) {
            if(board[r][i] == 1) return true;
        }

        for (int i = c - 1; i >=0 ; i--) {
            if (board[r][i] == 1) return true;
        }

        // col
        for (int i = r + 1; i < board.length; i++) {
            if (board[i][c] == 1) return true;
        }
        for (int i = r - 1; i>= 0  ; i--) {
            if (board[i][c] == 1) return true;
        }

        // diagonal right top
        for (int i = r + 1, j = c + 1; i < board.length && j < board.length; j++, i++) {
            if (board[i][j] == 1) return true;
        }

        // diag left top
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 1) return true;
        }

        // diag left bottom
        for (int i = r + 1, j = c - 1; i < board.length && j >=0 ; i++, j --) {
            if (board[i][j] == 1) return true;
        }

        // diag right bottom
        for (int i = r - 1, j = c + 1; i >=0 && j < board.length ; i--, j++) {
            if (board[i][j] == 1) return true;
        }

        return false;
    }
    public int[][] buildBoard(int n) {
        var board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[j][i] = 0;
            }
        }
        return board;
    }
}
