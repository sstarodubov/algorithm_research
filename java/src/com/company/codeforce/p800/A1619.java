package p800;

import java.util.Scanner;

public class A1619 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            var s = sc.next();
            helper(s);
        }
    }

    public static void helper(String s) {
        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }

        if ((s.length() & 1) == 1) {
            System.out.println("NO");
            return;
        }

        int p1 = 0, p2 = (s.length() / 2);

        while (p2 < s.length()) {
            if (s.charAt(p1++) != s.charAt(p2++)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
