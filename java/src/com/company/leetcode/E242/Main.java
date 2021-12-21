package com.company.leetcode.E242;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        assert new Solution().isAnagram("ab", "ba");
        assert new Solution().isAnagram("anagram", "nagaram");
        assert !new Solution().isAnagram("car", "rat");
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n) , space O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 1);
            else map.compute(s.charAt(i), (k, v) -> v + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.get(t.charAt(i)) == null) return false;
            map.computeIfPresent(t.charAt(i), (k, v) -> v - 1);
            if (map.get(t.charAt(i)) <= 0) map.remove(t.charAt(i));
        }
        return map.isEmpty();
    }
}


