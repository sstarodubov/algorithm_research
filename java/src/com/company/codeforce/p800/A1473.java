package p800;

import java.util.Scanner;

public class A1473 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = read(n, sc);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] <= d) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        if (max <= d) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
