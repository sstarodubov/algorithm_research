package p800;

import java.util.Scanner;

public class A749 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println(1);
            System.out.println("2");
            return;
        }

        if (n == 3) {
            System.out.println(1);
            System.out.println("3");
            return;
        }

        if ((n & 1) == 0) {
            int ans = n / 2;
            System.out.println(ans);
            System.out.println("2 ".repeat(ans));
        } else {
            int ans = (n - 3) / 2;
            System.out.println(ans + 1);
            System.out.println("2 ".repeat(ans) + "3");
        }
    }
}
