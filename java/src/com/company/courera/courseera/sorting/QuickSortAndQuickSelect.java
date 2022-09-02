package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortAndQuickSelect {

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 4, 4, 4, 4, 4, 5, 1, 6};
        var qs = new QuickSortAndQuickSelect();
        qs.sort(arr);
        System.out.println(Arrays.toString(arr));
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

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo;

        while (i <= gt) {
            if (a[i] < v) swap(a, lt++, i++);
            else if (a[i] > v) swap(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
