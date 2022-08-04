package p800;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class LinelandMail {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int last = arr.length - 1;

        for (int i = 0; i < n; i++) {
            int mn;
            int mx;
            if (i == 0) {
                mn = abs(arr[1] - arr[0]);
                mx = abs(arr[last] - arr[0]);
            } else if (i == last) {
                mx = abs(arr[last] - arr[0]);
                mn = abs(arr[last] - arr[last - 1]);
            } else {
                mn = min(abs(arr[i] - arr[i - 1]), abs(arr[i] - arr[i + 1]));
                mx = max(abs(arr[i] - arr[0]), abs(arr[i] - arr[last]));
            }

            System.out.println(mn + " " + mx);
        }
    }
}
