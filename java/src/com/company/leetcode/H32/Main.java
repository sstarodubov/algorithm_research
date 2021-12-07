package com.company.leetcode.H32;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        assert 6 == new Solution().longestValidParentheses("()(())");
        assert 4 == new Solution().longestValidParentheses(")()())");
        System.out.println("tests passed");
    }
}

class Pair {
    public int idx;
    public char letter;

    public Pair(int idx, char letter) {
        this.idx = idx;
        this.letter = letter;
    }
}

class Solution {

    // time O(n) and space O(n)
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        if (s.length() == 2) return s.charAt(0) == '(' && s.charAt(1) == ')' ? 2 : 0;

        int[] dp = new int[s.length()];
        var stack = new ArrayDeque<Pair>(s.length() * 2);

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (stack.isEmpty()) stack.add(new Pair(i, letter));
            else {
                var pair = stack.peek();
                if (pair.letter == '(' && letter == ')') {
                    stack.pop();
                    dp[i] = 1;
                    dp[pair.idx] = 1;
                } else stack.push(new Pair(i, letter));
            }
        }
        int max = 0;
        int curSum = 0;
        for (int bit : dp) {
            if (bit == 1) curSum++;
            else {
                max = Math.max(curSum, max);
                curSum = 0;
            }
        }
        max = Math.max(curSum, max);
        return max;
    }
}
