package com.company;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LongestSubstringWithoutDuplication {

    public static void main(String[] args) {
        assert "mentisac".equals(findLongestSubstring("clementisacap"));
    }

    // time O(n) space O(n)
    public static String findLongestSubstring(String s) {
        var subs = new LinkedList<LinkedHashMap<Character, Integer>>();
        var curSub = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!curSub.containsKey(letter)) curSub.put(letter, i);
            else {
                subs.add(curSub);
                i = curSub.get(letter);
                curSub = new LinkedHashMap<>();
            }
            if (i == s.length() - 1) subs.add(curSub);
        }
        int maxIdx = 0;
        int maxL = 0;
        int i = 0;
        for (var e : subs) {
            if (e.keySet().size() > maxL) {
                maxL = e.keySet().size();
                maxIdx = i;
            }
            i++;
        }

        var map = subs.get(maxIdx);
        var sb = new StringBuilder();
        for (var c : map.keySet()) {
            sb.append(c);
        }
        return sb.toString();
    }
}
