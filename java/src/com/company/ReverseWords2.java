package com.company;

public class ReverseWords2 {
    public static void main(String[] args) {

        assert reverseWords("  hello world").equals("  olleh dlrow") : 2;

        assert "s'teL ekat edoCteeL tsetnoc".equals(reverseWords("Let's take LeetCode contest")) : 1;

        System.out.println("tests passed");
    }

    // Time O(n^2) and Space O(n)
    public static String reverseWords(String s) {
        var sb = new StringBuilder(s);
        int l = 0, r = 0;
        while (true) {
            while (Character.isSpaceChar(sb.charAt(r))) {
                r++;
                l = r;
            }
            while (r < sb.length() && !Character.isSpaceChar(sb.charAt(r))) {
                r++;
            }
            swap(l, r - 1, sb);
            if (r >= sb.length()) {
                return sb.toString();
            }
        }
    }

    public static void swap(int l, int r, StringBuilder sb) {
        while (l < r) {
            char tmp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, tmp);
            l++;
            r--;
        }
    }
}
