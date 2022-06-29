from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        mn = [0] * len(nums)
        mx = [0] * len(nums)
        mn[0] = nums[0]
        mx[0] = nums[0]

        for i in range(1, len(nums)):
            n = nums[i]
            mxp = nums[i] * mx[i - 1]
            mnp = nums[i] * mn[i - 1]
            mn[i] = min(n, mnp, mxp)
            mx[i] = max(n, mnp, mxp)

        return max(max(mn), max(mx))


assert Solution().maxProduct([-1, 2, -3, 4, -5]) == 120
assert Solution().maxProduct([2, 3, -2, 4]) == 6
