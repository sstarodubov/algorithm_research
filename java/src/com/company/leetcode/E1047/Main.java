package com.company.leetcode.E1047;

import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        assert new Solution().removeDuplicates("abbaca").equals("ca");
        assert new Solution().removeDuplicates("azxxzy").equals("ay");
        System.out.println("tests passed");
    }
}

class Solution {
    public String removeDuplicates(String s) {
        var st = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            st.addLast(s.charAt(i));
            while (st.size() >= 2) {
                boolean rem = false;
                var p = st.removeLast();
                var pp = st.removeLast();
                if (p == pp) {
                    rem = true;
                } else {
                    st.addLast(pp);
                    st.addLast(p);
                }

                if (!rem) break;
            }
        }
        var sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }
}
