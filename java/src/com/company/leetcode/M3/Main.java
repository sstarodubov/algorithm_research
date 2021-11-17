package com.company.leetcode.M3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        assert 3 == new Solution().lengthOfLongestSubstring("aabaab!bb");
        assert 2 == new Solution().lengthOfLongestSubstring("aab");
        assert 2 == new Solution().lengthOfLongestSubstring("abba");
        assert 1 == new Solution().lengthOfLongestSubstring(" ");
        assert 3 == new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) and space O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        int ans = 0;
        int start = 0;
        var map = new HashMap<Character, Integer>();
        for (int end = 0; end < s.length(); end++) {
            char curLetter = s.charAt(end);
            int amount = map.getOrDefault(curLetter, 0);
            if (amount == 0) {
                ans = Math.max(end - start + 1, ans);
                map.put(curLetter, amount + 1);
            } else {
                while (s.charAt(start) != curLetter) {
                    map.compute(s.charAt(start), (k,val) -> val - 1);
                    start++;
                }
                start++;
            }
        }

        return ans;
    }
}
