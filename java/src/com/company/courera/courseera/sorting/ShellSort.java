package sorting;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        var ints = new int[]{4, 4, 4, 4, 4, 4, 5, 6, 1, 3, 2};

        shellSort(ints);

        System.out.println(Arrays.toString(ints));

    }


    public static void shellSort(int[] a) {
        int n = a.length;

        int h = 1;

        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int t = a[j];
                    a[j] = a[j - h];
                    a[j - h] = t;
                }
            }

            h = h / 3;
        }
    }
}
