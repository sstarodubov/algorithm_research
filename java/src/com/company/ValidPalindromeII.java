package com.company;

public class ValidPalindromeII {
    public static void main(String[] args) {

        assert validPalindrome("ebcbbececabbacecbbcbe") : -10;
        assert validPalindrome("cbbcc") : -1;
        assert validPalindrome("fabba") : 0;
        assert validPalindrome("aba") : 1;
        assert validPalindrome("abca") : 2;
        System.out.println("tests passed");
    }

    // Space O(1) and Time O(n)
    public static boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                boolean lB = validPalindrome(s, l + 1, r);
                boolean rB = validPalindrome(s, l, r - 1);
                return lB || rB;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else return false;
        }
        return true;
    }
}
