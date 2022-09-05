package p800;

import java.util.Scanner;

public class B1520 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            helper(n);
        }
    }

    private static void helper(long n) {
        long size = 0;
        long mask = 0;
        long t = n;
        while (n != 0) {
            n /= 10;
            mask += Math.pow(10, size);
            size++;
        }
        long fDig = t < 10 ? t : (long) (t / (Math.pow(10, size - 1)));
        if (t < 10) {
            System.out.println(t);
        } else {
            long p = mask * fDig;
            var x = (size - 1) * 9;
            var add = p % 10;
            var result = x + add;
            if (t < p) {
                result--;
            }
            System.out.println(result);
        }

    }
}
