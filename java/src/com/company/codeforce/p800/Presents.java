package p800;

import java.util.Scanner;

public class Presents {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[sc.nextInt() - 1] = i + 1;
        }

        displayArr(arr);
        sc.close();
    }

    private static void displayArr(int[] arr) {
        final var sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
