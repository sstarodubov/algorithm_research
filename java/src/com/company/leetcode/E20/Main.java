package com.company.leetcode.E20;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        assert !new Solution().isValid("([)]");
        assert new Solution().isValid("()[]{}");
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n), space O(n)
    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>(s.length() * 2);

        for (char letter : s.toCharArray()) {
            if (stack.isEmpty()) stack.add(letter);
            else {
                var peek = stack.peek();
                if (letter == '}' && peek == '{') stack.pop();
                else if (letter == ')' && peek == '(') stack.pop();
                else if (letter == ']' && peek == '[') stack.pop();
                else stack.push(letter);
            }
        }

        return stack.isEmpty();
    }
}