package com.company.leetcode.E205;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        assert !new Solution().isIsomorphic("badc", "baba");
        assert new Solution().isIsomorphic("egg", "add");
        assert !new Solution().isIsomorphic("foo", "bar");
        assert new Solution().isIsomorphic("paper", "title");
        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) , space O(n)
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        var m = new HashMap<Character, Character>();
        var rm = new HashMap<Character, Character>();
        for (int i = 0; i < t.length(); i++) {
            char cur = s.charAt(i);
            if (m.containsKey(cur)) {
                if (m.get(cur) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (!rm.containsKey(t.charAt(i))) {
                    rm.put(t.charAt(i), cur);
                    m.put(cur, t.charAt(i));
                } else return false;
            }
        }
        return true;
    }
}
