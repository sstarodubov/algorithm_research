package p800;

import java.util.Scanner;

public class A1462 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            var ans = new int[n];
            var arr = read(n, sc);
            int p = 0, l = 0, r = n - 1;
            boolean fl = true;
            while (p < n) {
                if (fl) {
                    ans[p++] = arr[l++];
                    fl = false;
                } else {
                    ans[p++] = arr[r--];
                    fl = true;
                }
            }
            print(ans);
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
