package p800;

import java.util.Scanner;

public class A1311 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            helper(a, b);
        }


    }

    private static void helper(int a, int b) {
        int d = a - b;

        if (d == 0) {
            System.out.println(0);
        } else if (d > 0) {
            if ((d & 1) == 0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else {
            if ((d & 1) == 0) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }
}
