package p800;

import java.util.Scanner;

public class A1358 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            hepler(n, m);
        }
    }

    private static void hepler(int n, int m) {
        if ((m & 1) == 0) {
            int ans = n * (m / 2);
            System.out.println(ans);
        } else {
            int ans = n * (m / 2);
            double c = n;
            double r = c / 2;
            int d = (int) Math.ceil(r);
            System.out.println(ans + d);
        }
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
