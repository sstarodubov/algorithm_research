from typing import List


class Solution:
    # time O(n), space O(1)
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        if len(prices) <= 1:
            return ans
        l = 0

        for r in range(1, len(prices)):
            if prices[r] < prices[l]:
                l = r
            ans = max(ans, prices[r] - prices[l])
        return ans


assert 5 == Solution().maxProfit([7, 1, 5, 3, 6, 4])
assert 0 == Solution().maxProfit([7, 6, 4, 3, 1])
