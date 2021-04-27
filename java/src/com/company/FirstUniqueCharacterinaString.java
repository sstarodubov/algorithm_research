package com.company;

import java.util.HashMap;

public class FirstUniqueCharacterinaString {

    public static void main(String[] args) {

        var el = new FirstUniqueCharacterinaString();
        assert 0 == el.firstUniqChar("leetcode") : 2;
        assert 2 == el.firstUniqChar("loveleetcode") : 1;
        assert -1 == el.firstUniqChar("aabb") : 0;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int firstUniqChar(String s) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
