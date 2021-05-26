package com.company;

public class RotateMatrix {
    public static void main(String[] args) {

        rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        });
        System.out.println("tests passed");
    }

    // Time O(n^2) and Space O(n)
    public static void rotate(int[][] matrix) {
        int[][] tmpMatrix = new int[matrix.length][matrix.length];
        int col = 0, row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                tmpMatrix[col][row] = matrix[j][i];
                row++;
                if (row == matrix.length) {
                    col++;
                    row = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(tmpMatrix[i], 0, matrix[i], 0, matrix.length);
        }
    }
}
