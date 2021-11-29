package com.company.leetcode.E167;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert Arrays.equals(new int[]{2, 3}, new Solution().twoSum(new int[]{5, 25, 75}, 100));
        assert Arrays.equals(new int[]{1, 2}, new Solution().twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n) , space O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            if (numbers[left] + numbers[right] > target) right--;
            else left++;
        }
        return null;
    }
}
