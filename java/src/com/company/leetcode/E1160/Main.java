package com.company.leetcode.E1160;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert 6 == new Solution().countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
        assert 10 == new Solution().countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr");
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n ^ 2 log n), space O(n)
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        var xs = new ArrayList<char[]>();
        for (var w : words) {
            var arr = w.toCharArray();
            Arrays.sort(arr);
            xs.add(arr);
        }
        var chs = chars.toCharArray();
        Arrays.sort(chs);
        for (int i = 0; i < xs.size(); i++) {
            var contains = isEq(xs.get(i), chs);
            if (contains) ans += xs.get(i).length;
        }

        return ans;
    }
    // time O(n)
    public boolean isEq(char[] arr, char[] exp) {
        if (arr.length >= exp.length) return false;
        int ptr = 0;
        for (int i = 0; i < exp.length; i++) {
            if (arr[ptr] == exp[i]) {
                ptr++;
            }
            if (ptr >= arr.length) return true;
        }
        return false;
    }
}