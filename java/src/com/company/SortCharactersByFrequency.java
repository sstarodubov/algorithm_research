package com.company;


import java.util.Arrays;
import java.util.HashMap;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        var el = new SortCharactersByFrequency();
        assert "eert".equals(el.frequencySort("tree")) : 1;
        assert "aaaccc".equals(el.frequencySort("cccaaa")) : 2;
        assert "bbAa".equals(el.frequencySort("Aabb")) : 3;

        System.out.println("tests passed");
    }

    // Time O(n^2) and Space O(n)
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            if (!map.containsKey(l)) map.put(l, 1);
            else map.put(l, map.get(l) + 1);
        }

        var list = new Pair[map.size()];

        int i = 0;
        for (var entry : map.entrySet()) {
            var p = new Pair(entry.getKey(), entry.getValue());
            list[i] = p;
            i++;
        }
        Arrays.sort(list, (p1, p2) -> p1.rep > p2.rep ? -1 : 1);
        StringBuilder b = new StringBuilder();
        for (var p : list) {
            int count = p.rep;
            while (count > 0) {
                b.append(p.letter);
                count--;
            }
        }
        return b.toString();
    }
    class Pair {
        char letter;
        int rep;
        Pair(char letter, int rep) {
            this.letter = letter;
            this.rep = rep;
        }
    }
}
