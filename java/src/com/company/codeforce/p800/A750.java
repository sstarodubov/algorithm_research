package p800;

import java.util.Scanner;

public class A750 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int left = 240 - k;

        int ans = 0;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if ((ans + (5 * i)) > left) {
                System.out.println(c);
                return;
            }
            c++;
            ans += (5 * i);
        }

        System.out.println(c);
    }
}
