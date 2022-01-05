package com.company.datastructureimpl;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorting {
    public static void main(String[] args) {
        var arr = new int[]{5, 4, 3, 2, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // time O(n^2), space O(1)
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int ptr = i - 1;
            int cur = i;
            while (ptr >= 0 && arr[ptr] > arr[cur]) {
                int tmp = arr[ptr];
                arr[ptr] = arr[cur];
                arr[cur] = tmp;
                ptr--;
                cur--;
            }
        }
    }

    // time O(n^2), space O(1)
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    // O (n log n), space O(n)
    public static void heapSort(int[] arr) {
        var heap = new PriorityQueue<Integer>(arr.length);
        for (int j : arr) {
            heap.add(j);
        }
        for (int i = 0; i < arr.length; i++) {
            assert heap.peek() != null;
            arr[i] = heap.poll();
        }
    }

    // time O(n^2), space O(1)
    public static void bubbleSort(int[] arr) {
        int end = arr.length;
        for (int i = 0; i < end; ) {
            while (i + 1 < end) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
                i++;
            }
            i = 0;
            end--;
        }

    }
}
