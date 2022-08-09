package p800;

import java.util.Scanner;

public class A148 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        int k = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int d = sc.nextInt();

        int escaped = 0;

        for (int i = 1; i <= d ; i++) {
            if (i % k != 0 && i % l != 0 && i % m != 0 && i % n != 0) {
                escaped++;
            }
        }


        System.out.println(d - escaped);
    }
}
