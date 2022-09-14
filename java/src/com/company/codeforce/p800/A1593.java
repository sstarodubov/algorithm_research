package p800;

import java.util.Arrays;
import java.util.Scanner;

public class A1593 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int mx = Math.max(a, Math.max(b, c));

        int[] ans = new int[3];

        if (a == mx) {
            if (b == mx || c == mx) {
                ans[0] = 1;
            } else {
                ans[0] = 0;
            }
        } else {
            ans[0] = mx - a + 1;
        }

        if (b == mx) {
            if (a == mx || c == mx) {
                ans[1] = 1;
            } else {
                ans[1] = 0;
            }
        } else {
            ans[1] = mx - b + 1;
        }


        if (c == mx) {
            if (a == mx || b == mx) {
                ans[2] = 1;
            } else {
                ans[2] = 0;
            }
        } else {
            ans[2] = mx - c + 1;
        }

        print(ans);
    }


    public static void print(int[] arr) {
        var s = new StringBuilder();
        for (int j : arr) {
            s.append(j).append(" ");
        }
        s.deleteCharAt(s.length() - 1);
        System.out.println(s);
    }
}
