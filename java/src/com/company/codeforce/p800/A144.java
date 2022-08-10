package p800;

import java.util.Scanner;

public class A144 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = readIntArr(sc, n);

        int min = Integer.MAX_VALUE, mnIdx = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (min > arr[i]) {
                mnIdx = i;
                min = arr[i];
            }
        }
        int mx = Integer.MIN_VALUE, mxIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mx) {
                mxIdx = i;
                mx = arr[i];
            }
        }

        int ans = mxIdx + (arr.length - 1) - mnIdx;
        if (mxIdx > mnIdx) {
            ans--;
        }
        System.out.println(ans);
    }

    private static void displayArr(int[] arr) {
        final var sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }

    private static int[] readIntArr(Scanner sc, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }
}
