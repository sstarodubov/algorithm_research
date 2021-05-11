package com.company;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        var m = new LongestSubstringWithoutRepeatingCharacters();

        assert 5 == m.lengthOfLongestSubstring("tmmzuxt") : 2000;
        assert 3 == m.lengthOfLongestSubstring("dvdf") : -1000;
        assert 3 == m.lengthOfLongestSubstring("pwwkew") : -1;
        assert 1 == m.lengthOfLongestSubstring(" ") : 1000;
        assert 1 == m.lengthOfLongestSubstring("bbbbb") : 1;
        assert 3 == m.lengthOfLongestSubstring("abcabcbb") : 0;
        assert 0 == m.lengthOfLongestSubstring("") : 9;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        var table = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!table.containsKey(letter) || (table.containsKey(letter) && table.get(letter)< start)) {
                table.put(letter, i);
                if (i == s.length() - 1) {
                    max = Math.max(max, (i - start) + 1);
                }
            } else {
                max = Math.max(max, i - start);
                int d = table.get(letter);
                start = d + 1;
                table.put(letter, i);
            }
        }
        return max;
    }
}
