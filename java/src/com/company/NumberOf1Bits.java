package com.company;

public class NumberOf1Bits {
    public static void main(String[] args) {
        var b = new NumberOf1Bits();

        assert 3 == b.hammingWeight(11) : "3";
        assert 31 == b.hammingWeight(-3) : "31";
        assert 1 == b.hammingWeight(128) : "1";
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int hammingWeight(int n) {
        char[] binary = Integer.toBinaryString(n).toCharArray();
        int out = 0;
        for (char b : binary) {
            if (b == '1') out++;
        }
        return out;
    }

}
