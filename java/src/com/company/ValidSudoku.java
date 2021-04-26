package com.company;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] validSudoku = new char[][]{
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

        var a = new ValidSudoku();

        assert a.isValidSudoku(validSudoku) : "1";
        char[][] invalidSudoku = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assert !a.isValidSudoku(invalidSudoku) : "2";
        System.out.println("tests passed");
    }

    // Time O(n ^ 2) and Space O(n)
    public boolean isValidSudoku(char[][] board) {
        var storage = new HashMap<Character,Boolean>();
        initMap(storage);
        
        // check rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                var cur = board[i][j];
                if (storage.get(cur) != null) {
                    if (storage.get(cur)) return false;
                    if (!storage.get(cur)) storage.put(cur, true);
                }
            }
            initMap(storage);
        }
        // check cols

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                var cur = board[j][i];
                if (storage.get(cur) != null) {
                    if (storage.get(cur)) return false;
                    if (!storage.get(cur)) storage.put(cur, true);
                }
            }
            initMap(storage);
        }

        // check squares
        if (!checkSquare(0, 0, storage, board) ) return false;
        if (!checkSquare(0, 3, storage, board) ) return false;
        if (!checkSquare(0, 6, storage, board) ) return false;
        if (!checkSquare(3, 0, storage, board) ) return false;
        if (!checkSquare(3, 3, storage, board) ) return false;
        if (!checkSquare(3, 6, storage, board) ) return false;
        if (!checkSquare(6, 0, storage, board) ) return false;
        if (!checkSquare(6, 3, storage, board) ) return false;
        if (!checkSquare(6, 6, storage, board) ) return false;

        return true;
    }

    public boolean checkSquare(int x , int y, Map<Character, Boolean> storage, char[][] board) {
        initMap(storage);
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j <  y + 3; j++) {
                if (board[j][i] == '.') continue;
                var cur = board[j][i];
                if (storage.get(cur) != null) {
                    if (storage.get(cur)) return false;
                    if (!storage.get(cur)) storage.put(cur, true);
                }
            }
        }
        return true;
    }

    public void initMap(Map<Character,Boolean> map) {
        var chars = new char[] {'1', '2', '3' , '4' , '5' ,'6', '7', '8' , '9'};
        for (char c : chars) {
            map.put(c, false);
        }
    }
}
