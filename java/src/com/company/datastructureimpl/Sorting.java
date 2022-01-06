package com.company.datastructureimpl;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        var arr = new int[]{5, 4, 3, 2, 1};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        int bucketLen = (int) Math.round(Math.sqrt(arr.length));
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        ArrayList<Integer>[] buckets = new ArrayList[bucketLen];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int val : arr) {
            int idx = (int) Math.ceil((float) val * bucketLen / (float) max);
            buckets[idx - 1].add(val);
        }

        for (var list : buckets) {
            Collections.sort(list);
        }

        int idx = 0;
        for (var list : buckets) {
            for (var val : list) {
                arr[idx] = val;
                idx++;
            }
        }
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
