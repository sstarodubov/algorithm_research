package com.company.datastructureimpl;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        var arr = new int[]{5, 4, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // time O(n^2), space O(1)
    public static void bubbleSort(int[] arr) {
        int end = arr.length;
        for (int i = 0; i < end; ) {
            int j = i + 1;
            while (j < end) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                i++;
                j++;
            }
            i = 0;
            end--;
        }

    }
}
