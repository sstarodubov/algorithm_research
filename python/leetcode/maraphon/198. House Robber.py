from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        dp = [0] * len(nums)
        dp[0], dp[1] = nums[0], nums[1]
        for i in range(2, len(nums)):
            f = dp[0:i - 1]
            if f:
                dp[i] = nums[i] + max(f)
            else:
                dp[i] = nums[i]

        return max(dp)


assert 4 == Solution().rob([1, 2, 3, 1])
assert 4 == Solution().rob([2, 1, 1, 2])
assert 12 == Solution().rob([2, 7, 9, 3, 1])
