package com.company.mfti.firstcoursealgo;

public class QuickSelect {

    private final int[] arr;
    private final int k;

    public QuickSelect(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public int getKLargest() {
        return quickSelect(0, arr.length - 1);
    }

    private int quickSelect(int l, int r) {
        if (l <= r) {
            int pIdx = partition(l, r);
            if (pIdx > k) {
                return quickSelect(l, pIdx - 1);
            } else if (pIdx < k) {
                return quickSelect(pIdx + 1, r);
            } else {
                return arr[k];
            }
        }
        return -1;
    }

    private void swapArr(int j, int k) {
        int t = arr[j];
        arr[j] = arr[k];
        arr[k] = t;
    }

    private int partition(int low, int high) {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                swapArr(i, pivotloc);
                pivotloc++;
            }
        }
        swapArr(high, pivotloc);
        return pivotloc;
    }
}
