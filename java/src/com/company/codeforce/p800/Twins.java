package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Twins {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int curSum = 0;
        int allSum = sum(arr);

        for (int i = 0; i < arr.length; i++) {
            if (curSum > allSum) {
                System.out.println(i);
                return;
            }

            curSum += arr[i];
            allSum -= arr[i];
        }

        System.out.println(arr.length);
    }

    public static int sum(Integer[] arr) {
        int ans = 0;
        for (int val : arr) {
            ans += val;
        }
        return ans;
    }
}
