package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        var arr = new int[]{3, 1, 5, 2, 1, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] aux, int l, int r) {
        if (r <= l) return;
        int m = l + (r - l) / 2;
        sort(arr, aux, l, m);
        sort(arr, aux, m + 1, r);
        merge(arr, aux, l, m, r);
    }

    private static void merge(int[] a, int[] aux, int l, int m, int r) {
        for (int k = l; k <= r; k++) {
            aux[k] = a[k];
        }

        int i = l, j = m + 1;

        for (int k = i; k <= r; k++) {
            if (i > m) a[k] = aux[j++];
            else if (j > r) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
