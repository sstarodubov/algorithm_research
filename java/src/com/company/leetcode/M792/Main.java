package com.company.leetcode.M792;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        assert 3 == new Solution().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
        assert 2 == new Solution().numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"});

        System.out.println("tests passed");
    }
}


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        var map = new HashMap<Character, List<String>>();
        for (var word : words) {
            var cur = map.getOrDefault(word.charAt(0), new ArrayList<>());
            cur.add(word);
            map.put(word.charAt(0), cur);
        }

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            var bucket = map.getOrDefault(s.charAt(i), Collections.emptyList());
            map.remove(s.charAt(i));
            for (String word : bucket) {
                if (word.length() == 1) {
                    ans++;
                } else {
                    var trimmedWord = word.substring(1);
                    var firstLetter = trimmedWord.charAt(0);
                    var list = map.getOrDefault(firstLetter, new ArrayList<>());
                    list.add(trimmedWord);
                    map.put(firstLetter, list);
                }
            }
        }
        return ans;
    }
}