from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        coins.sort(reverse=True)
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0

        for cur_amount in range(1, amount + 1):
            for coin in coins:
                rest = cur_amount - coin
                if rest < 0:
                    continue
                elif rest == 0:
                    dp[cur_amount] = 1
                else:
                    if dp[rest] == float("inf"):
                        continue
                    dp[cur_amount] = min(dp[cur_amount], 1 + dp[rest])

        if dp[-1] == float("inf"):
            return -1
        return int(dp[-1])


assert 20 == Solution().coinChange([186, 419, 83, 408], 6249)
assert 1 == Solution().coinChange([1, 2], 2)
assert 3 == Solution().coinChange(coins=[1, 2, 5], amount=11)
assert 0 == Solution().coinChange([1], 0)
assert -1 == Solution().coinChange(coins=[2], amount=3)
