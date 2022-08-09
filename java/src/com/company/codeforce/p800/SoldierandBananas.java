package p800;

import java.util.Scanner;

public class SoldierandBananas {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int s = (((w * (w + 1)) * k)) / 2;

        int ans = s - n;
        if (ans < 0) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
