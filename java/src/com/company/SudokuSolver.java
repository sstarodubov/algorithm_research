package com.company;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        var el = new SudokuSolver();
        el.solveSudoku(board);

    }

    public void solveSudoku(char[][] board) {
        backtrack(board);

    }

    public boolean backtrack(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrack(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c, char num) {

        for (int i = 0; i < 9; ++i) {
            if (board[r][i] == num) return false;
            if (board[i][c] == num) return false;
        }

        int boxR = r / 3 * 3;
        int boxC = c / 3 * 3;
        for (int r1 = 0; r1 < 3; ++r1) {
            for (int c1 = 0; c1 < 3; ++c1) {
                if (board[boxR + r1][boxC + c1] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
