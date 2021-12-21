package com.company.leetcode.E392;

public class Main {
    public static void main(String[] args) {
        assert new Solution().isSubsequence("b", "abc");
        assert new Solution().isSubsequence("abc", "ahbgdc");
        assert !new Solution().isSubsequence("axc", "ahbgdc");

        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n), space O(1)
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (s.length() > t.length()) return false;
        int ptrS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(ptrS)) {
                ptrS++;
            }
            if (ptrS >= s.length()) return true;
        }
        return false;
    }
}
