from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) <= 1:
            return True
        dp = [0] * (len(nums))
        dp[-1] = 1
        for i in range(len(nums) - 2, -1, -1):
            for j in range(nums[i]):
                idx = j + i + 1
                if idx >= len(nums):
                    continue
                if dp[idx] == 1:
                    dp[i] = 1
                    break
        return dp[0] == 1


assert Solution().canJump([2, 0])
assert Solution().canJump([2, 3, 1, 1, 4])
assert Solution().canJump([0])
assert not Solution().canJump([3, 2, 1, 0, 4])
