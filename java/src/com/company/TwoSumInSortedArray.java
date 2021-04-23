package com.company;

import java.util.Arrays;

public class TwoSumInSortedArray {
    public static void main(String[] args) {
        assert Arrays.equals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9)) : "9";
        assert Arrays.equals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6)) : "6";
        assert Arrays.equals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1)) : "-1";
        System.out.println("tests passed");
    }

    // Space O(1) and Time O(n)
    public static int[] twoSum(int[] numbers, int target) {
        int lPtr = 0;
        int rPtr = numbers.length - 1;
        while (lPtr < rPtr) {
            if (numbers[lPtr] + numbers[rPtr] == target) return new int[] {lPtr + 1, rPtr + 1 };
            else if (numbers[lPtr] + numbers[rPtr] < target) lPtr++;
            else rPtr--;
        }
        return new int[] {-1, -1};
    }

}
