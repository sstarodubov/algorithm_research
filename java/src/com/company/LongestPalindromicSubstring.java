package com.company;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        var l = new LongestPalindromicSubstring();
        assert "bab".equals(l.longestPalindrome("babad")) : 1;
        assert "bb".equals(l.longestPalindrome("cbbd")) : 2;
        assert "a".equals(l.longestPalindrome("a")) : 3;
        assert "a".equals(l.longestPalindrome("ac")) : 4;

        System.out.println("tests passed");
    }

    public String longestPalindrome(String s) {
        int[] curLong = new int[] {0, 1};
        for (int i = 1; i < s.length(); i++) {
            var odd = findLongestPalindrome(s, i - 1, i + 1);
            var even = findLongestPalindrome(s, i - 1, i);
            var longest = new int [2];
            if (odd[1] -odd[0] > even[1] - even[0]) longest = odd;
            else longest = even;

            if (longest[1] - longest[0] > curLong[1] - curLong[0]) curLong = longest;
            
        }
        return s.substring(curLong[0], curLong[1]);
    }

    public int[] findLongestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && r >= 0) {
            if (s.charAt(l) != s.charAt(r)) break;
            l--;
            r++;
        }
        return new int[] {l + 1, r};
    }
}
