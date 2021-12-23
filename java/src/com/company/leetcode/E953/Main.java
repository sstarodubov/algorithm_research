package com.company.leetcode.E953;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        assert !new Solution().isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz");
        assert !new Solution().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz");
        assert new Solution().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n ^ 2), space O(order)
    public boolean isAlienSorted(String[] words, String order) {
        var dict = new HashMap<Character, Integer>((int) (order.length() * 1.5));
        for (int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isWordLess(words[i], words[i + 1], dict)) {
                return false;
            }
        }
        return true;
    }

    public boolean isWordLess(String s1, String s2, Map<Character, Integer> alphabet) {
        int s2ptr = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s2ptr >= s2.length()) return false;
            int val = alphabet.get(s1.charAt(i));
            int s2val = alphabet.get(s2.charAt(s2ptr));
            if (val > s2val) return false;
            if (val < s2val) return true;
            s2ptr++;
        }
        return true;
    }
}
