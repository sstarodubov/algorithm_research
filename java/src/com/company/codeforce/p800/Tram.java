package p800;

import java.util.Scanner;

public class Tram {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cap = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();

            cap = cap - out + in;
            ans = Math.max(ans, cap);
        }

        System.out.println(ans);
    }
}
