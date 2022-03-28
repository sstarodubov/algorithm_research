package com.company.leetcode.E1309;

public class Main {
    public static void main(String[] args) {
        assert "jkab".equals(new Solution().freqAlphabets("10#11#12"));
    }
}

class Solution {
    public String freqAlphabets(String s) {
        var sb = new StringBuilder();
        int ptr = s.length() - 1;
        while (ptr >= 0) {
            if (s.charAt(ptr) != '#') {
                int a = Integer.parseInt(String.valueOf(s.charAt(ptr)));
                char ch = (char) (a + 96);
                sb.append(ch);
                ptr -= 1;
            } else {
                var first = Integer.parseInt(String.valueOf(s.charAt(ptr - 1)));
                var second = Integer.parseInt(String.valueOf(s.charAt(ptr - 2)));
                char ch = (char) (((second * 10) + first) + 96);
                sb.append(ch);
                ptr -= 3;
            }
        }
        return sb.reverse().toString();
    }
}



