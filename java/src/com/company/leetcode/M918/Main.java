package com.company.leetcode.M918;

public class Main {
    public static void main(String[] args) {
        assert 10 == new Solution().maxSubarraySumCircular(new int[]{5, -3, 5});
        assert 10 == new Solution().maxSubarraySumCircular(new int[]{-7, 1, 2, 7, -2, -5});
        assert 3 == new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2});
        assert 19 == new Solution().maxSubarraySumCircular(new int[]{2, -2, 2, 7, 8, 0});
        System.out.println("tests passed");
    }
}

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 0) return 0;
        int sum = A[0];
        int maxSoFar = A[0];
        int maxTotal = A[0];
        int minTotal = A[0];
        int minSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            int num = A[i];
            maxSoFar = Math.max(num, maxSoFar + num);
            maxTotal = Math.max(maxSoFar, maxTotal);

            minSoFar = Math.min(num, minSoFar + num);
            minTotal = Math.min(minTotal, minSoFar);

            sum += num;
        }
        if (sum == minTotal) return maxTotal;
        return Math.max(sum - minTotal, maxTotal);
    }
}