package com.company.leetcode.M792;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        assert 3 == new Solution().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
        assert 2 == new Solution().numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"});

        System.out.println("tests passed");
    }
}


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        var map = new HashMap<String, Integer>();
        for (var word : words) {
            if (map.containsKey(word)) map.compute(word, (k, v) -> v + 1);
            else map.put(word, 1);
        }
        int ans = 0;
        for (var word : map.keySet()) {
            if (isSubSeq(word, s)) {
                ans += map.get(word);
            }
        }
        return ans;
    }

    boolean isSubSeq(String sub, String str) {
        int subPtr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (subPtr >= sub.length()) return true;
            if (str.charAt(i) == sub.charAt(subPtr)) {
                subPtr++;
            }
        }
        return subPtr == sub.length();
    }
}