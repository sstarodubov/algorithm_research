package org.example.e67;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1111", "1111"));
    }
}

class Solution {
    public char[] toArr(String s, int len) {
        char[] arr = new char[len];
        Arrays.fill(arr, '0');
        int offset = len - s.length();
        for (int i = 0; i < s.length(); i++) {
            arr[i + offset] = s.charAt(i);
        }
        return arr;
    }

    public String addBinary(String a, String b) {
        int n = a.length() > b.length() ? a.length() : b.length();
        char[] a_arr = toArr(a, n);
        char[] b_arr = toArr(b, n);

        char[] ret = new char[n];
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int s = a_arr[i] + b_arr[i] + carry;
            if (s == 99) {
                ret[i] = '1';
                carry = 1;
            } else if (s == 98) {
                ret[i] = '0';
                carry = 1;
            } else if (s == 97) {
                ret[i] = '1';
                carry = 0;
            } else {
                ret[i] = '0';
                carry = 0;
            }
        }

        return carry == 0 ? new String(ret) : "1" + new String(ret);
    }
}
