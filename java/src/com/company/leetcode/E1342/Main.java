package com.company.leetcode.E1342;

public class Main {
    public static void main(String[] args) {
        assert 6 == new Solution().numberOfSteps(14);
        System.out.println("tests passed");
    }
}

class Solution {
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num = num >> 1;
            }
            ans++;
        }
        return ans;
    }
}
