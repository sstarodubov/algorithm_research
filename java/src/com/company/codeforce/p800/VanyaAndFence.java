package p800;

import java.util.Scanner;

public class VanyaAndFence {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() > h) {
                ans += 2;
            } else {
                ans += 1;
            }
        }

        System.out.println(ans);

    }
}
