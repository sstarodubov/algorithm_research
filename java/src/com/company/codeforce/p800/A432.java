package p800;

import java.util.Arrays;
import java.util.Scanner;

public class A432 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] xs = read(n, sc);
        if (n < 3) {
            System.out.println(0);
            return;
        }
        Arrays.sort(xs);
        int ans = 0;

        for (int i = 0; i + 2 < xs.length; i += 3) {
            ans += isOk(xs[i], xs[i + 1], xs[i + 2], k);
        }

        System.out.println(ans);
    }

    public static int isOk(int a, int b, int c, int k) {
        return ((a + k <= 5) && (b + k <= 5) && (c + k) <= 5) ? 1 : 0;
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
