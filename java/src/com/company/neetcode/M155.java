package com.company.neetcode;

import java.util.ArrayDeque;
import java.util.Map;

public class M155 {

    class MinStack {

        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(Math.min(min.peek(), val));
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}


