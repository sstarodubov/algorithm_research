package com.company;

public class ValidPalindrome {
    public static void main(String[] args) {

        assert !isPalindrome("0P") : 1;
        assert isPalindrome("A man, a plan, a canal: Panama") : 1;
        assert isPalindrome(".,") : 0;
        assert !isPalindrome("race a car") : 2;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        if (sb.length() == 0) return true;
        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            if (sb.charAt(left) == sb.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
