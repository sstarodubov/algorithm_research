package com.company;

import java.util.ArrayDeque;

public class MinimumRemovetoMakeValidParentheses {

    public static void main(String[] args) {
        var m = new MinimumRemovetoMakeValidParentheses();

        assert "ab(c)d".equals(m.minRemoveToMakeValid("a)b(c)d")) : 1;
        System.out.println("tests passed");
    }

    class Pair {
        public char ps;
        public int idx;

        public Pair(char ps, int idx) {
            this.idx = idx;
            this.ps = ps;
        }
    }

    // Time O(n ^ 2) and Space O(n)
    public String minRemoveToMakeValid(String s) {
        var sb = new StringBuilder(s);
        var stack = new ArrayDeque<Pair>();
        for (int i = 0; i < sb.length(); i++) {
            char letter = sb.charAt(i);
            if (letter != '(' && letter != ')') continue;
            if (stack.isEmpty()){
                stack.push(new Pair(letter, i));
            } else {
                Pair peek = stack.peek();
                if (peek.ps == '(' && letter == ')') stack.pop();
                else stack.push(new Pair(letter, i));
            }
        }
        for (var pair : stack) {
            sb.deleteCharAt(pair.idx);
        }
        return sb.toString();
    }
}
