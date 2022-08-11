package p800;

import java.util.Scanner;

public class A996 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = {100, 20, 10, 5, 1};
        int ans = 0;
        while (n != 0) {
            for (int coin : coins) {
                if (coin > n) continue;
                int r = n % coin;
                ans += ((n - r) / coin);
                n = r;
            }
        }
        System.out.println(ans);
    }
}
