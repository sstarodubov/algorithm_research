package p800;

import java.util.Scanner;

public class NextRound {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;

        for (int score : arr) {
            if (score != 0 && score >= arr[k - 1]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
