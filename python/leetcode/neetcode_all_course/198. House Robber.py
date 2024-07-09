from typing import List


class Solution:
    def min_idx(self, dp, idx):
        if idx < 0:
            return 0
        s = float("-inf")
        for i in range(idx - 1):
            s = max(dp[i], s)
        return s

    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * (n + 2)

        for i in range(n):
            dp[i + 2] = nums[i] + self.min_idx(dp, i + 2)

        return max(dp)


print(Solution().rob([2, 1, 1, 2]))