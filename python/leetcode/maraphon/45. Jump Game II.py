from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [float("inf")] * len(nums)
        dp[0] = 0
        for i in range(len(nums)):
            for j in range(nums[i] + 1):
                if dp[-1] != float("inf"):
                    return dp[-1]
                dp[j + i] = min(dp[i + j], dp[i] + 1)
        return dp[-1]


assert 2 == Solution().jump([7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3])
assert 3 == Solution().jump([1, 2, 1, 3, 1, 1, 4])
