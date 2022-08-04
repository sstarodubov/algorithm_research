package p800;

import java.util.Scanner;

public class EvenOdds {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long m = ((n & 1) == 1) ? (n / 2) + 1 : (n / 2);

        if (k <= m) {
            System.out.println(((k - 1) * 2) + 1);
        } else {
            long d = k - m;
            System.out.println(d * 2);
        }
    }
}
