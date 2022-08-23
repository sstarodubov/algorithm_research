package p800;

import java.util.Scanner;

public class A1360 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int mx = Math.max(a, b);
            int mn = Math.min(a, b);
            int c = Math.max(mx, 2 * mn);
            System.out.println((int) Math.pow(c, 2));
        }
    }
}


