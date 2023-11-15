package p1200;

import java.util.Scanner;

public class A514 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        long x = sc.nextLong();
        long res = 0;
        double p = 0;
        long min, b;
        while (x != 0) {
            if (x == 9) {
                min = x;
            } else {
                b = x % 10;
                min = Math.min(b, 9 - b);
            }
            res += (long) (min * Math.pow(10, p));
            x /= 10;
            p++;
        }
        System.out.println(res);
    }
}
