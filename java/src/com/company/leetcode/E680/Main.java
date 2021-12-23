package com.company.leetcode.E680;

public class Main {
    public static void main(String[] args) {
        assert new Solution().validPalindrome("abdcdUba");
        assert !new Solution().validPalindrome("abc");
        assert new Solution().validPalindrome("abca");
        assert new Solution().validPalindrome("aba");
        assert new Solution().validPalindrome("abba");
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n), space O(1)
    public boolean validPalindrome(String s) {
        if (s.length() <= 2) return true;
        var cords = helper(s, 0, s.length() - 1);
        if (cords[2] == 1) return true;
        int[] left = helper(s, cords[0], cords[1] - 1);
        int[] right = helper(s, cords[0] + 1, cords[1]);
        return left[2] == 1 || right[2] == 1;
    }

    public int[] helper(String s, int start, int end) {
        int lp = start;
        int rp = end;
        while (lp < rp) {
            if (s.charAt(lp) != s.charAt(rp)) {
                return new int[]{lp, rp, 0};
            }
            lp++;
            rp--;
        }
        return new int[]{start, end, 1};
    }
}



