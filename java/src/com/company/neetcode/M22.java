package com.company.neetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class M22 {

    public static void main(String[] args) {
        System.out.println(new M22().generateParenthesis(1));
    }
    static ArrayDeque<Character> stack = new ArrayDeque<>();
    static int n;

    public List<String> generateParenthesis(int n) {
        M22.n = n * 2;
        var ret = new ArrayList<String>();

        backtrack(new StringBuilder(), ret);

        return ret;
    }

    boolean isValid(StringBuilder s) {
        stack.clear();
        char cur, last;
        for (int i = 0; i < n; i++) {
            cur = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                last = stack.peek();

                if (last == '(' && cur == ')') {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }

        return stack.isEmpty();
    }

    void backtrack(StringBuilder comb, List<String> result) {
        if (comb.length() > n) {
            return;
        }
        if (comb.length() == n) {
            if (isValid(comb)) {
                result.add(comb.toString());
            }
        } else {
            comb.append("(");
            backtrack(comb, result);
            comb.deleteCharAt(comb.length() - 1);

            comb.append(")");
            backtrack(comb, result);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
