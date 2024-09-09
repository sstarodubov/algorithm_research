package com.company.neetcode;

import java.util.ArrayDeque;

public class M150 {
    public int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();

        for (var t : tokens) {
            if (stack.isEmpty()) {
                stack.push(Integer.valueOf(t));
            } else {
                switch (t) {
                    case "*" -> stack.push(stack.pop() * stack.pop());
                    case "-" -> {
                        var last = stack.pop();
                        var prelast = stack.pop();
                        stack.push(last - prelast);
                    }
                    case "+" -> stack.push(stack.pop() + stack.pop());
                    case "/" -> {
                        var last = stack.pop();
                        var prelast = stack.pop();
                        stack.push(last / prelast);
                    }
                    default -> stack.push(Integer.valueOf(t));
                }
            }
        }

        return stack.pop();
    }
}
