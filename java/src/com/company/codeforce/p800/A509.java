package p800;

import java.util.Scanner;

public class A509 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matx = new int[n][n];
        for (int i = 0; i < n; i++) {
            matx[0][i] = 1;
            matx[i][0] = 1;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                matx[row][col] = matx[row - 1][col] + matx[row][col - 1];
            }
        }

        System.out.println(matx[n - 1][n - 1]);
    }
}
