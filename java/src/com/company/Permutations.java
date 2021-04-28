package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        var p = new Permutations();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
        System.out.println("done");
    }
    public List<List<Integer>> permute(int[] nums) {
        var permutations = new LinkedList<List<Integer>>();
        permuteHelper(0, nums, permutations);
        return permutations;
    }

    public void swap(int[] arr, int i, int y) {
        int tmp = arr[i];
        arr[i] = arr[y];
        arr[y] = tmp;
    }

    public void permuteHelper(int idx, int[] arr, List<List<Integer>> permutations) {
        if (idx == arr.length - 1) {
            var newArr = new ArrayList<Integer>();
            for (var el : arr) {
                newArr.add(el);
            }
            permutations.add(newArr);
        } else {
            for (int y = idx; y < arr.length; y++) {
                swap(arr, idx, y);
                permuteHelper(idx + 1, arr, permutations);
                swap(arr, y, idx);
            }
        }
    }
}
