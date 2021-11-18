package com.company.leetcode.M48;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(matrix);
    }
}


class Solution {

    // time O(n^2) and space O(n)
    public void rotate(int[][] matrix) {
        var m = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                m[i][j] = matrix[i][j];
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = matrix.length - 1, newCol = 0; col >= 0; col--, newCol++) {
                matrix[row][newCol] = m[col][row];
            }
        }
    }
}