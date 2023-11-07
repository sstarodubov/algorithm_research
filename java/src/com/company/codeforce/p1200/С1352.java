package p1200;

import java.util.Scanner;

public class С1352 {
    //C1352

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static long order(long a, long n) {
        long r = a % n;
        long w = a / n;

        return ((n - 1) * w) + r;
    }

    private static void solve() {
        long n = sc.nextLong();
        long k = sc.nextLong();
        long lt = 1;
        long rt = n * k - 1;

        while (true) {
            if (lt % n == 0) {
                lt++;
            }
            if (rt % n == 0) {
                rt--;
            }
            long cur_value = (rt + lt) / 2;
            long cur_order = order(cur_value, n);
            if (cur_order == k) {
                if (cur_value % n == 0) {
                    System.out.println(cur_value - 1);
                } else {
                    System.out.println(cur_value);
                }
                return;
            } else if (cur_order > k) {
                rt = cur_value - 1;
            } else {
                lt = cur_value + 1;
            }
        }
    }
}
