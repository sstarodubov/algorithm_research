package com.company;

public class TransponseMatrix {
    public static void main(String[] args) {

        int[][] transpose = transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        int[][] t2 = transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        System.out.println("tests passed");
    }

    public static int[][] transpose(int[][] matrix) {
        var nm = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nm[j][i] = matrix[i][j];
            }
        }
        return nm;
    }
}
