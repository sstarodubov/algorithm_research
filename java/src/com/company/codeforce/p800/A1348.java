package p800;

import java.util.Scanner;

public class A1348 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = 0;
            int b = 0;

            a += Math.pow(2, n);
            for (int j = 1; j <= (n / 2) - 1; j++) {
                a += Math.pow(2, j);
            }

            for (int j = n / 2; j < n; j++) {
                b += Math.pow(2, j);
            }

            System.out.println(Math.abs(a - b));
        }
    }
}
