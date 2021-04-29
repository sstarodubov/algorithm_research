package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        var n = new FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK();
        assert 1 == n.findMinFibonacciNumbers(5) : 0;
        assert 2 == n.findMinFibonacciNumbers(7) : 1;
        assert 2 == n.findMinFibonacciNumbers(10) : 2;
        assert 3 == n.findMinFibonacciNumbers(19) : 3;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int findMinFibonacciNumbers(int k) {
        var xs = buildFiboSeq(k);
        int ans = 0;
        int p = k;
        while (true) {
            p -= xs.get(xs.size() - 1);
            ans++;
            if (p <= 0) return ans;
            while (p < xs.get(xs.size() - 1)) {
                xs.remove(xs.size() - 1);
            }
        }
    }

    public List<Integer> buildFiboSeq(int k) {
        var xs = new ArrayList<Integer>();
        xs.add(0);
        xs.add(1);
        var x = xs.get(xs.size() - 1);
        while (true) {
            x = xs.get(xs.size() - 1) + xs.get(xs.size() - 2);
            if (x > k) break;
            xs.add(x);
        }
        return xs;
    }
}
