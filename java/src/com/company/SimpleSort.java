package com.company;

import java.util.Arrays;

public class SimpleSort {

    public static void main(String[] args) {
        int[] list = {10, 4, 9, 5, 1};
        insertSort(list);
        System.out.println(Arrays.toString(list));
    }


    public static void insertSort(int[] list) {
        int curElementPtr = 1;
        int prevElementPtr = 0;

        while (curElementPtr < list.length) {
            int initCurPosition = curElementPtr;
            while (prevElementPtr >= 0 && list[prevElementPtr] > list[curElementPtr]) {
                int tmp = list[curElementPtr];
                list[curElementPtr] = list[prevElementPtr];
                list[prevElementPtr] = tmp;
                prevElementPtr--;
                curElementPtr--;
            }
            curElementPtr = initCurPosition + 1;
            prevElementPtr = curElementPtr - 1;
        }
    }

    public static void bobbleSort(int[] list) {
        int lastSortedIdx = list.length - 1;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lastSortedIdx; i++) {
                if (list[i] > list[i + 1]) {
                    int tmp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = tmp;
                    sorted = false;
                }
            }
            lastSortedIdx--;
        }
    }

    public static void selectSort(int[] arr) {
        int curIdx = 0;
        while (curIdx < arr.length) {
            int minIdx = curIdx;
            for (int i = curIdx; i < arr.length; i++) {
                if (arr[curIdx] > arr[i]) {
                    minIdx = i;
                }
            }
            int tmp = arr[curIdx];
            arr[curIdx] = arr[minIdx];
            arr[minIdx] = tmp;
            curIdx++;
        }
    }
}
