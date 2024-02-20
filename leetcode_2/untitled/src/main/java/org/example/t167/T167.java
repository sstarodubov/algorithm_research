package org.example.t167;

import java.util.Arrays;

public class T167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{1, 2, 3, 4}, 3)));
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            }

            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{-1, -1};
    }
}
