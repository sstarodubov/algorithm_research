package com.company.neetcode;

import java.util.ArrayDeque;

public class E20 {

    public static void main(String[] args) {
        assert new E20().isValid("([])");
    }
    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>(s.length());
        int n = s.length();
        char cur, last;
        for (int i = 0; i < n; i++) {
           cur = s.charAt(i);
           if (stack.isEmpty()) {
               stack.push(cur);
           } else {
              last = stack.peek();

              if (last == '(' && cur == ')') {
                  stack.pop();
              } else if (last == '[' && cur == ']') {
                  stack.pop();
              } else if (last == '{' && cur == '}') {
                  stack.pop();
              } else {
                  stack.push(cur);
              }
           }
        }

        return stack.isEmpty();
    }
}
