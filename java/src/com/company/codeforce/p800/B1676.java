package p800;

import java.util.Arrays;
import java.util.Scanner;

public class B1676 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        int[] xs = read(n , sc);

        int mn = Arrays.stream(xs).min().getAsInt();

        int ans = 0;

        for (int i = 0; i < xs.length; i++) {
            ans += (xs[i] - mn);
        }

        System.out.println(ans);
    }

    int greaterCommonDeviser(int a, int b) {
        int R;
        while ((a % b) > 0) {
            R = a % b;
            a = b;
            b = R;
        }
        return b;
    }

    public static void print(int[] arr) {
        var s = new StringBuilder();
        for (int j : arr) {
            s.append(j).append(" ");
        }
        s.deleteCharAt(s.length() - 1);
        System.out.println(s);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
