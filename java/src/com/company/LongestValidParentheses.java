package com.company;


import java.util.ArrayDeque;

public class LongestValidParentheses {

    public static void main(String[] args) {
        var l = new LongestValidParentheses();

        assert 6 == l.longestValidParentheses("()(()))") : 0;
        assert 2 == l.longestValidParentheses("(()") : 1;
        assert 4 == l.longestValidParentheses(")()())") : 2;
        assert 0 == l.longestValidParentheses("") : 3;
        assert 2 == l.longestValidParentheses("()(()") : 4;

        System.out.println("tests passed");
    }

    // Space O(n) and Space O(n)
    public int longestValidParentheses(String s) {
        int[] mask = new int[s.length()];
        var stack = new ArrayDeque<Pair>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                var pair = new Pair(s.charAt(i), i);
                stack.push(pair);
            } else {
                var last = stack.peek();
                if (last.p == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else stack.push(new Pair(s.charAt(i), i));
            }
        }
        for (var pair : stack) {
            mask[pair.idx] = 1;
        }

        int ans = 0;
        int cur = 0;
        for (int bit : mask) {
            if (bit == 1) {
                ans = Math.max(ans, cur);
                cur = 0;
            } else cur++;
        }

        return Math.max(ans, cur);
    }

    private class Pair {
        int idx;
        char p;

        Pair(char p, int idx) {
            this.idx = idx;
            this.p = p;
        }
    }
}
