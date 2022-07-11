from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)

        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = nums[1]

        for i in range(2, len(nums)):
            for j in range(i - 2, -1, -1):
                dp[i] = max(dp[j] + nums[i], dp[i])

        return max(dp)


assert Solution().rob([2, 1, 1, 2]) == 4
assert Solution().rob([1, 2, 3, 1]) == 4
