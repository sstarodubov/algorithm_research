from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        xmin, xmax = [0] * len(nums), [0] * len(nums)
        xmin[0], xmax[0] = nums[0], nums[0]
        for i in range(1, len(nums)):
            k = nums[i] * xmin[i - 1]
            n = nums[i] * xmax[i - 1]
            xmin[i] = min(k, n, nums[i])
            xmax[i] = max(k, n, nums[i])
        return max(xmax)


print(Solution().maxProduct([2, 3, -2, 4]))
print(Solution().maxProduct([-2, 0, -1]))
