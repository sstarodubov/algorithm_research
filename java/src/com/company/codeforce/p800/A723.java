package p800;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.asin;

public class A723 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int[] xs = read(3, sc);
        Arrays.sort(xs);

        int s = (xs[0] + xs[1] + xs[2]) / 3;

        int ans = abs(xs[0] - s) + abs(xs[2] - s);
        System.out.println(ans);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
