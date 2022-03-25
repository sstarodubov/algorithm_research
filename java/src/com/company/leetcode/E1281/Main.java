package com.company.leetcode.E1281;

public class Main {
    public static void main(String[] args) {
        assert new Solution().subtractProductAndSum(234) == 15;
        System.out.println("tests passed");
    }
}


class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        int tmp = n;
        while (tmp > 0) {
            int x = tmp % 10;
            sum += x;
            product *= x;
            tmp /= 10;
        }

        return product - sum;
    }
}
