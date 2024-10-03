package com.company.neetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class M424 {

    public static void main(String[] args) {
        assert 4 == new M424().characterReplacement("ABAB", 2);
        assert 4 == new M424().characterReplacement("AABABBA", 1);
        assert 7 == new M424().characterReplacement("AAABBABBB", 2);
    }

    public int characterReplacement(String s, int k) {
        var map = new HashMap<Character, Integer>();
        int ret = 0;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while ((r - l + 1) - (map.values().stream().max(Comparator.comparingInt(a -> a)).get()) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            ret = Math.max(ret, r - l + 1);
        }

        return ret;
    }
}
