from typing import List


class Solution:
    def helper(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = nums[1]

        for i in range(2, len(nums)):
            for j in range(i - 2, -1, -1):
                dp[i] = max(dp[j] + nums[i], dp[i])

        return max(dp)

    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)

        ys = nums[1:]
        xs = nums[:-1]

        return max(self.helper(ys), self.helper(xs))


assert Solution().rob([200, 3, 140, 20, 10]) == 340
assert Solution().rob([1, 2, 3]) == 3
assert Solution().rob([1, 2, 1, 1]) == 3
assert Solution().rob([2, 3, 2]) == 3
