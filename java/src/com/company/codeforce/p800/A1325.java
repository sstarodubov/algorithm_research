package p800;

import java.util.Scanner;

public class A1325 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int x = sc.nextInt();
        System.out.printf("%d %d\n", x - 1, 1);
    }
}
