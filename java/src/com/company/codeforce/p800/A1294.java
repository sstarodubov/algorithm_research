package p800;

import java.util.Arrays;
import java.util.Scanner;

public class A1294 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            var arr = read(3, sc);
            int mx = Arrays.stream(arr).max().orElse(-1);
            int n = sc.nextInt();

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < mx) {
                    n -= (mx - arr[j]);
                    if (n < 0) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (n >= 0) {
                if (n % 3 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}