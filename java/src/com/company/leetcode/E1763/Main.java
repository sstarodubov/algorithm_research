package com.company.leetcode.E1763;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        assert "aAa".equals(new Solution().longestNiceSubstring("YazaAay"));
        System.out.println("tests passed");
    }
}

class Solution {
    public String longestNiceSubstring(String s) {
        int mx = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                var str = s.substring(i, j + 1);
                if (isNice(str) && str.length() > mx) {
                    mx = str.length();
                    ans = str;
                }
            }
        }
        return ans;
    }
    public boolean isNice(String s) {
        var set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        for (Character val : set) {
            if (Character.isUpperCase(val)) {
                if (!set.contains(Character.toLowerCase(val))) return false;
            } else {
                if (!set.contains(Character.toUpperCase(val))) return false;
            }
        }
        return true;
    }
}
