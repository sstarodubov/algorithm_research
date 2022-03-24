package com.company.leetcode.E1221;

public class Main {
    public static void main(String[] args) {
        assert new Solution().balancedStringSplit("RLRRLLRLRL") == 4;
        System.out.println("tests passed");
    }
}


class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int ctn = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') ctn += 1;
            else ctn -= 1;
            if (ctn == 0) ans++;
        }
        return ans;
    }
}