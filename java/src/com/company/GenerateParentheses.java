package com.company;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        var m = new GenerateParentheses();
        assert m.generateParenthesis(3).size() == 5;
        System.out.println("tests passed");
    }

    public List<String> generateParenthesis(int n) {
        var results = new HashSet<String>();
        backtrack(results, new ArrayList<>(), n, 0);
        return new ArrayList<>(results);
    }

    public void backtrack(Set<String> results, List<String> curStr, int n, int start) {
        // if curStr is good , add it to solutions
        if (curStr.size() == n * 2 && !results.contains(curStr) && isCorrect(curStr) ) {
            results.add(String.join("", curStr));
            return;
        }
        for (int i = start; i < n * 2; i++) {
            // check whether it is valid
            if (isValid(curStr)) {

                // apply
                if (i % 2 == 0) curStr.add("(");
                else curStr.add(")");

                // next attempt to find solution
                backtrack(results, curStr, n, start + 1);

                // backtrack
                curStr.remove(curStr.size() - 1);
            }
        }
    }


    public boolean isValid(List<String> str) {
        int c = 0;
        int j = 0;
        for (var l : str) {
            if (l.equals("(")) c++;
            if (l.equals(")")) j++;
        }
        return c >= j;
    }


    public boolean isCorrect(List<String> list) {
        var stack = new ArrayDeque<String>();
        for (String letter : list) {
            if (stack.isEmpty()) {
                stack.push(letter);
            } else {
                String peek = stack.peek();
                if ((peek.equals("(") && letter.equals(")")) || (letter.equals("(") && peek.equals(")"))) {
                    stack.pop();
                } else stack.add(letter);

            }
        }
        return stack.size() == 0;
    }
}
