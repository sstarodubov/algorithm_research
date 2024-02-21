package org.example.E205;

import java.util.HashMap;

public class E205 {

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        var m = new HashMap<Character, Character>();
        var mm = new HashMap<Character, Character>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char l1 = s.charAt(i);
            char l2 = t.charAt(i);

            if (!m.containsKey(l1) && !mm.containsKey(l2)) {
                m.put(l1, l2);
                mm.put(l2, l1);
                continue;
            }

            if (l2 == m.getOrDefault(l1, '0') && l1 == mm.getOrDefault(l2, '0')) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}