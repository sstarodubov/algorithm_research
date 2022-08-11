package sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 6};
        var qs = new QuickSort();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(qs.select(arr, i));
        }
    }

    //time O(n log n)
    public void sort(int[] arr) {
        shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }


    //time O(n)
    public int select(int[] arr, int k) {
        shuffle(arr);
        int l = 0, r = arr.length - 1;
        while (r > l) {
            int p = partition(arr, l, r);
            if (p < k) l = p + 1;
            else if (p > k) r = p - 1;
            else return arr[k];
        }

        return arr[k];
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) return;

        int pIdx = partition(arr, l, r);
        sort(arr, l, pIdx - 1);
        sort(arr, pIdx + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int i = l, j = r + 1;
        while (true) {
            while (arr[++i] < arr[l]) {
                if (i == r) break;
            }

            while (arr[l] < arr[--j]) {
                if (j == l) break;
            }

            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, l, j);

        return j;
    }

    private void swap(int[] arr, int k, int j) {
        int t = arr[k];
        arr[k] = arr[j];
        arr[j] = t;
    }

    private void shuffle(int[] arr) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            swap(arr, j, i);
        }
    }
}
