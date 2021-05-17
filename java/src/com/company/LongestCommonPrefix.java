package com.company;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        assert "flow".equals(longestCommonPrefix(new String[]{"flower", "flow", "floweht"})) : 0;
        System.out.println("tests passed");
    }

    // Time O(n ^ 2) and Space O(n)
    public static String longestCommonPrefix(String[] strs) {
        var ans = new StringBuilder();
        int lIdx = 0;
        while (true) {
            if (lIdx >= strs[0].length()) return ans.toString();
            char letter = strs[0].charAt(lIdx);
            for (int i = 1; i < strs.length; i++) {
                if (lIdx >= strs[i].length()) return ans.toString();
                if (letter != strs[i].charAt(lIdx)) return ans.toString();
            }
            ans.append(letter);
            lIdx++;
        }
    }
}
