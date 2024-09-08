package com.company.neetcode;

import java.util.HashSet;
import java.util.Set;

public class M36 {

    public static void main(String[] args) {
        var res = new M36().isValidSudoku(new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'7', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'6', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                });

        System.out.println(res);
    }

    static Set<Character> set = new HashSet<>(9);

    public boolean isValidSudoku(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        char cur;
        for (int r = 0; r < ROWS; r++) {
            set.clear();
            for (int c = 0; c < COLS; c++) {
                cur = board[r][c];
                if (cur == '.') continue;
                if (set.contains(cur)) {
                    return false;
                }
                else set.add(cur);
            }
        }

        for (int c = 0; c < COLS; c++) {
            set.clear();
            for (int r = 0; r < ROWS; r++) {
                cur = board[r][c];
                if (cur == '.') continue;
                if (set.contains(cur)) {
                    return false;
                }
                else set.add(cur);
            }
        }


        for (int r = 0; r < ROWS; r += 3) {
            for (int c = 0; c < COLS; c += 3) {
                set.clear();

                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        cur = board[i][j];
                        if (cur == '.') continue;
                        if (set.contains(cur)) {
                            return false;
                        }
                        else set.add(cur);
                    }
                }

            }
        }


        return true;
    }
}
