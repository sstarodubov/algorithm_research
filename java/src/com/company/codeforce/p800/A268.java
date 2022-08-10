package p800;

import java.util.Scanner;

public class A268 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i][0] == arr[j][1]) ans++;
            }
        }

        System.out.println(ans);
    }
}
