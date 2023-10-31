package p800;

import java.util.Scanner;

public class A1690 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        int d = n / 3;
        int r = n % 3;
        int h1, h2, h3;
        if (r == 2) {
            h1 = d + 2;
            h2 = d + 1;
            h3 = d - 1;
        } else if (r == 1) {
            h1 = d + 2;
            h2 = d;
            h3 = d - 1;
        } else {
            h1 = d + 1;
            h2 = d;
            h3 = d - 1;
        }

        System.out.printf("%d %d %d\n", h2, h1, h3);
    }
}
