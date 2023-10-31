package p1200;

import java.util.Arrays;
import java.util.Scanner;

public class B492 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        double res = Double.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, arr[i] - arr[i - 1]);
        }

        int g = Math.max(arr[0], l - arr[n - 1]);

        if (g >= res / 2) {
            System.out.println(g);
        } else {
            System.out.println(res / 2);
        }
    }
}
