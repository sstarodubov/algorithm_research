package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {

    /*
     * Space O(n) Time O(n)
     */
    public boolean isBalancedBrackets(String brackets) {
        Deque<Character> stack = new LinkedList<>();
        for (char e : brackets.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(e);
                continue;
            }
            Character peek = stack.peek();
            if (peek == '[' && e == ']') stack.pop();
            else if  (peek == '(' && e == ')') stack.pop();
            else if (peek == '{' && e == '}') stack.pop();
            else stack.push(e);
        }
        return stack.isEmpty();
    }
}
