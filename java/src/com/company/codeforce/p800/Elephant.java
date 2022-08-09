package p800;

import java.util.Scanner;

public class Elephant {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int x = sc.nextInt();

        int ans = 0;
        int r;
        if (x >= 5) {
            r = x / 5;
            ans += r;
            x -= (5 * r);
        }

        if (x >= 4) {
            r = x / 4;
            ans += r;
            x -= (4 * r);
        }

        if (x >= 3) {
            r = x / 3;
            ans += r;
            x -= (3 * r);
        }

        if (x >= 2) {
            r = x / 2;
            ans += r;
            x -= (2 * r);
        }

        if (x >= 1) {
            ans += 1;
        }
        System.out.println(ans);
    }
}
