import java.util.Scanner;

import static java.lang.Math.abs;

public class MakeProductEqualOne {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int[] arr = new int[n];

        long ans = 0;
        int sign = 1;
        boolean containsZero = false;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > 0) {
                long val = arr[i] - 1;
                ans += val;
            } else if (arr[i] < 0) {
                long val = abs(arr[i] + 1);
                sign *= -1;
                ans += val;
            } else {
                containsZero = true;
                ans += 1;
            }
        }

        if (sign == 1) {
            System.out.println(ans);
        } else {
            if (containsZero) {
                System.out.println(ans);
            } else {
                System.out.println(ans + 2);
            }
        }
    }
}
