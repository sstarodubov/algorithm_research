package com.company;

public class ReverseString {
    public static void main(String[] args) {
        var re = new ReverseString();
        re.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        System.out.println("tests passed");
    }


    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
