package p800;

import java.util.Scanner;

public class A1352 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int t = sc.nextInt();

        var sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = 0, p = 0;
            while (n != 0) {
                int la = n % 10;
                if (la != 0) {
                    sb.append((int) (la * Math.pow(10, p))).append(" ");
                    c++;
                }
                p++;
                n = n / 10;
            }

            System.out.println(c);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
