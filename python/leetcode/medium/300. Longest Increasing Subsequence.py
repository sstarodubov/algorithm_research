from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = 1
        for i in range(1, len(nums)):
            c, t = nums[i], 0
            for j in range(i - 1, -1, -1):
                if nums[j] < c:
                    t = max(dp[j], t)

            dp[i] = t + 1

        ans = max(dp)
        return ans


assert Solution().lengthOfLIS([7, 7, 7, 7, 7, 7, 7]) == 1
assert Solution().lengthOfLIS([0, 1, 0, 3, 2, 3]) == 4
assert Solution().lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]) == 4
