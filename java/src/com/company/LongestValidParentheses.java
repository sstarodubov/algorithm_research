package com.company;


import java.util.ArrayDeque;
import java.util.BitSet;

public class LongestValidParentheses {

    public static void main(String[] args) {
        var l = new LongestValidParentheses();

        assert 6 == l.longestValidParentheses("()(())") : 0;
        assert 2 == l.longestValidParentheses("(()") : 1;
        assert 4 == l.longestValidParentheses(")()())") : 2;
        assert 0 == l.longestValidParentheses("") : 3;
        assert 2 == l.longestValidParentheses("()(()") : 4;

        System.out.println("tests passed");
    }

    // Space O(n) and Space O(n)
    public int longestValidParentheses(String s) {
        BitSet mask = new BitSet(s.length());
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                var lastIdx = stack.peek();
                if (s.charAt(lastIdx) == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else stack.push(i);
            }
        }
        for (var i :stack) {
            mask.set(i);
        }

        int ans = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mask.get(i)) {
                ans = Math.max(ans, cur);
                cur = 0;
            } else cur++;
        }

        return Math.max(ans, cur);
    }
}
