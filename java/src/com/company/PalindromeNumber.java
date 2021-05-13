package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeNumber {
    public static void main(String[] args) {
        var m = new PalindromeNumber();
        assert m.isPalindrome(2000000002) : 20000002;
        assert m.isPalindrome(5) : 5;
        assert !m.isPalindrome(1011) : 1011;
        assert m.isPalindrome(121) : 121;
        assert m.isPalindrome(1221) : 1221;
        assert !m.isPalindrome(1213) : 1213;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        long devider = 10;
        Deque<Integer> buf = new ArrayDeque<>();
        while (x != 0) {
            int r = (int) (((long) x) % devider);
            buf.addFirst((int) (r / (devider / 10)));
            x -= r;
            devider *= 10;
        }

        while (!buf.isEmpty()) {
            long left = buf.pollFirst();
            if (buf.isEmpty()) return true;
            long right = buf.pollLast();
            if (left != right) return false;
        }
        return true;
    }
}
