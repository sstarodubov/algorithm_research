package com.company.leetcode.E268;

public class Main {
    public static void main(String[] args) {
        assert 2 == new Solution().missingNumber(new int[]{3, 0, 1});

        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) , space O(1)
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i] ^ i;
        }
        ans ^= nums.length;
        return ans;
    }
}
