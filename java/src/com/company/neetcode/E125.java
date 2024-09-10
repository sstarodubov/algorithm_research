package com.company.neetcode;


public class E125 {
    public static void main(String[] args) {
        System.out.println(new E125().isPalindrome("0P"));
    }
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while(l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l >= r) {
                break;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            } else {
                l++;
                r--;
            }

        }

        return true;
    }
}
