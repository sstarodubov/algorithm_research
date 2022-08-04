package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class KetaFirstStep {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        var n = in.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        arr[0] = in.nextInt();
        int ans = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = in.nextInt();
            int prev = arr[i - 1];
            int cur = arr[i];
            if (prev <= cur) {
                dp[i] = dp[i - 1] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(ans);
    }
}
