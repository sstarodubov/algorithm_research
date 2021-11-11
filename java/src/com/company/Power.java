package com.company;

public class Power {

    public static void main(String[] args) {
        assert capitalizeWord("i love js").equals("I Love Js");
        assert isPalindrome("hooh");
        assert isPalindrome("hohoh");
        assert power(2, 4) == 16;
        assert gcd(12, 8) == 4;
        assert gcd(48, 18) == 6;
        assert decimalToBinary(10) == 1010;
        assert decimalToBinary(5) == 101;
        assert factorial(7) == 5040;
        System.out.println("tests passed");
    }

    public static String capitalizeWord(String str) {
        if (str.length() == 2) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        var lastLetter = str.substring(str.length() - 1);
        char preLastLetter = str.charAt(str.length() - 2);
        if (Character.isSpaceChar(preLastLetter)) return capitalizeWord(str.substring(0, str.length() - 1)) + lastLetter.toUpperCase();
        return capitalizeWord(str.substring(0, str.length() - 1)) + lastLetter;
    }

    public static char first(String str) {
        if (str.length() == 0) return '0';
        char firstLetter = str.charAt(0);
        if (Character.isUpperCase(firstLetter)) return firstLetter;
        return first(str.substring(1));
    }

    public static boolean isPalindrome(String s) {
        if ("".equals(s)) return true;
        if (s.length() == 1) return true;

        var firstLetter = s.charAt(0);
        var lastLetter = s.charAt(s.length() - 1);
        return firstLetter == lastLetter && isPalindrome(s.substring(1, s.length() - 1));
    }

    public static int factorial(int num) {
        if (num <= 1) return 1;
        return num * factorial(num - 1);
    }

    public static int power(int number, int p) {
        if (p <= 0) return 1;
        return number * power(number, p - 1);
    }

    // Euclidean algorithm
    public static int gcd(int great, int div) {
        int remain = great % div;
        if (remain == 0) return div;
        return gcd(div, remain);
    }

    public static int decimalToBinary(int num) {
        return helperDecToBin(num, 0, 0);
    }

    private static int helperDecToBin(int n, int q, int ans) {
        if (n == 0) return ans;
        int lastBit = n & 1;
        n = n >> 1;
        ans += lastBit * (int) Math.pow(10, q);
        return helperDecToBin(n, q + 1, ans);
    }
}
