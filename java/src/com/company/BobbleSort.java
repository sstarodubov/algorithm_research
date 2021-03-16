package com.company;

import java.util.Arrays;

public class BobbleSort {

    public static void main(String[] args) {
        int[] list = {10, 4, 9, 5, 1};
        bobbleSort(list);
        System.out.println(Arrays.toString(list));
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
}
