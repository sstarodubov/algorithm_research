package com.company.leetcode.E1071;


public class Main {
    public static void main(String[] args) {
        assert new Solution().gcdOfStrings("ABCABC", "ABC").equals("ABC");
        assert new Solution().gcdOfStrings("ABABAB", "ABAB").equals("AB");
        assert new Solution().gcdOfStrings("LEET", "CODE").equals("");
    }
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String sm, lg;
        if (str1.length() > str2.length()) {
            sm = str2;
            lg = str1;
        } else {
            sm = str1;
            lg = str2;
        }
        var d = sm;

        while (!d.equals("")) {
            if (lg.length() % d.length() != 0 || sm.length() % d.length() != 0) {
                d = d.substring(0, d.length() - 1);
                continue;
            }
            StringBuilder a = new StringBuilder();
            while (a.length() < sm.length()) {
                a.append(d);
            }

            var b = new StringBuilder();
            while (b.length() < lg.length()) {
                b.append(d);
            }

            if (a.toString().equals(sm) && b.toString().equals(lg)) return d;

            d = d.substring(0, d.length() - 1);
        }

        return d;
    }
}