package com.company;

public class Power {

    public static void main(String[] args) {
        assert power(5, 3) == 125;
        assert gcd(12, 8) == 4;
        assert gcd(48, 18) == 6;
        assert decimalToBinary(10) == 1010;
        assert decimalToBinary(5) == 101;
        System.out.println("tests passed");
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
