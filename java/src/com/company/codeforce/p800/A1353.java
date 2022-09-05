package p800;

import java.util.Scanner;

public class A1353 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            helper(n, m);
        }
    }

    private static void helper(long n, long m) {
        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (n == 2) {
            System.out.println(m);
            return;
        }

        System.out.println(m * 2);
    }
}
