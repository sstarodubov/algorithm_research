package com.company.neetcode;

public class E121 {
    public int maxProfit(int[] prices) {
        int l = 0;
        int ret = 0;
        for (int r = 0; r < prices.length; r++) {
            if (prices[l] < prices[r]) {
                l = r;
            } else {
                ret = Math.max(prices[r] - prices[l], ret);
            }
        }
        return ret;
    }
}
