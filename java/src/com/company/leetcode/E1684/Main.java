package com.company.leetcode.E1684;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        assert 2 == new Solution().countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"});
        System.out.println("tests passed");
    }
}


class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        var set = new HashSet<Character>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                   if (!set.contains(word.charAt(i))) {
                       ans--;
                       break;
                   }
            }
        }

        return ans;
    }
}
