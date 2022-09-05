package p800;

import java.util.Scanner;

public class A1426 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            helper(n, x);
        }
    }

    private static void helper(int n, int x) {
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(1);
        } else {
            double c = n - 2;
            double d = c / x;
            System.out.println(((int) Math.ceil(d)) + 1);
        }
    }
}
