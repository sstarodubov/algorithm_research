package com.company.leetcode.E1486;

public class Main {
    public static void main(String[] args) {
        assert 8 == new Solution().xorOperation(5, 0);
        System.out.println("tests passed");
    }
}

class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= start + (2 * i);
        }
        return ans;
    }
}
