package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EvaluatetheBracketPairsofaString {
    public static void main(String[] args) {
        var eva = new EvaluatetheBracketPairsofaString();
        assert "bobistwoyearsold".equals(eva.evaluate("(name)is(age)yearsold", List.of(List.of("name", "bob"), List.of("age", "two")))) : 1;
        System.out.println("tests passed");
    }

    class Pair {
        public Pair(String value, int idx) {
            this.idx = idx;
            this.value = value;
        }
        public String value;
        public int idx;
    }
    // Time O(n) and Space O(n)
    public String evaluate(String s, List<List<String>> knowledge) {
        var keys = new HashMap<String, String>();
        var idxs = new LinkedList<Pair>();
        for (var x : knowledge) {
            keys.put(x.get(0), x.get(1));
        }
        var sb = new StringBuilder(s);
        boolean reading = false;
        var key = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ')') {
                idxs.addFirst(new Pair(key.toString(), i - key.length() - 1));
                key = new StringBuilder();
                reading = false;
            }

            if (reading) {
                key.append(sb.charAt(i));
            }
            if (sb.charAt(i) == '(') {
                reading = true;
            }

        }
        for (var pair : idxs) {
            sb.delete(pair.idx, pair.idx + pair.value.length() + 2);
            sb.insert(pair.idx, keys.getOrDefault(pair.value, "?"));
        }
        return sb.toString();
    }
}
