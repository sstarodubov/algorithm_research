package p800;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1579 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            var s = sc.next();
            helper(s);
        }
    }

    private static void helper(String s) {
        int A = 0;
        int B = 0;
        int C = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A' -> A++;
                case 'B' -> B++;
                case 'C' -> C++;
            }
        }

        int d = Math.min(A, B);
        A -= d;
        B -= d;

        if (B <= 0 && C > 0) {
            System.out.println("NO");
            return;
        }
        int dd = Math.min(B, C);

        B -= dd;
        C -= dd;

        if (A > 0 || B > 0 || C > 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
