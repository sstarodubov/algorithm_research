package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 */
public class Tribonacci {
    public static void main(String[] args) {

        assert 53798080 == tribonacci(31);
        assert 1389537 == tribonacci(25) : 1;

        System.out.println("test passed");
    }

    // Time (n) and Space O(n)
    public static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, Map<Integer, Integer> memo) {
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (memo.get(n) != null) return memo.get(n);
        int num = tribonacci(n - 3, memo) + tribonacci(n - 2, memo) + tribonacci(n - 1, memo);
        memo.put(n, num);
        return num;
    }
}
