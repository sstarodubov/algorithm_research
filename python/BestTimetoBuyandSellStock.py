from typing import List
"""
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in 
the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
"""

class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        cur_min = prices[0]
        for i in range(1, len(prices)):
            price = prices[i]
            max_profit = max(max_profit, price - cur_min)
            cur_min = min(cur_min, price)
        return max_profit


s = Solution()

assert s.maxProfit([7, 1, 5, 3, 6, 4]) == 5, 1
assert s.maxProfit([7, 6, 4, 3, 1]) == 0, 2

print("tests passed")
