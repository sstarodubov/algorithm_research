package p800;

import java.util.Scanner;

public class A1337 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn (sc);
        }
    }

    private static void fn(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.printf("%d %d %d\n", b, c, c);
    }
}
