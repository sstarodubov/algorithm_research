from typing import List

"""
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in 
the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
"""


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1
        max_profit = 0
        while r < len(prices):
            if prices[l] < prices[r]:
                max_profit = max(max_profit, prices[r] - prices[l])
            else:
                l = r
            r += 1
        return max_profit


s = Solution()

assert s.maxProfit([7, 1, 5, 3, 6, 4]) == 5, 1
assert s.maxProfit([7, 6, 4, 3, 1]) == 0, 2

print("tests passed")
