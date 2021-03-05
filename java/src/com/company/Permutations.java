package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3,4};
        List<int[]> ints = permuteWrapper(arr);
        System.out.println(ints);
    }

    public static List<int[]> permuteWrapper(int[] arr) {
        var permutations = new LinkedList<int[]>();
        permute(0, arr, permutations);
        return permutations;
    }

    public static void swap(int[] arr, int i, int y) {
        int tmp = arr[i];
        arr[i] = arr[y];
        arr[y] = tmp;
    }

    public static void permute(int idx, int[] arr, List<int[]> permutations) {
        if (idx == arr.length - 1) {
            int[] newArr = Arrays.copyOf(arr, arr.length);
            permutations.add(newArr);
        } else {
            for (int y = idx; y < arr.length; y++) {
                swap(arr, idx, y);
                permute(idx + 1, arr, permutations);
                swap(arr, y, idx);
            }
        }
    }
}
