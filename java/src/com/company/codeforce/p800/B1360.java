package p800;

import java.util.Arrays;
import java.util.Scanner;

public class B1360 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] read = read(n, sc);
            Arrays.sort(read);
            int diff = Integer.MAX_VALUE;
            for (int j = 1; j < n; j++) {
                int c = read[j] - read[j - 1];
                if (diff > c) {
                    diff = c;
                }
            }
            System.out.println(diff);
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
