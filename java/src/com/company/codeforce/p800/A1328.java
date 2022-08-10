package p800;

import java.util.Scanner;

public class A1328 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            if ((a % b) == 0) {
                System.out.println(0);

            } else {
                System.out.println((((a / b) + 1) * b) - a);
            }
        }
    }
}
