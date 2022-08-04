package p800;

import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
