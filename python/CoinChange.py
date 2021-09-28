from typing import List
"""
You are given an integer array coins representing coins of different denominations and 
an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

"""

class Solution:

    # cpu O(n ^2 ) ram O(n)
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for cur_amount in range(amount + 1):
                if cur_amount < coin:
                    continue
                rest = cur_amount - coin
                dp[cur_amount] = min(dp[cur_amount], 1 + dp[rest])
        return -1 if dp[-1] == float("inf") else dp[-1]


s = Solution()
assert s.coinChange(coins=[1, 2, 5], amount=11) == 3, 1
assert s.coinChange(coins=[2], amount=3) == -1, 2
assert s.coinChange([1], amount=0) == 0, 3
assert s.coinChange([1], 1) == 1, 4
assert s.coinChange([1], 2) == 2, 5
assert s.coinChange([186, 419, 83, 408], 6249) == 20, -1

print("tests passed")
