from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        mx, mx_idx = 0, 0
        for i in range(len(nums)):
            if nums[i] > mx:
                mx_idx = i
                mx = nums[i]
        smx = 0
        for i in range(len(nums)):
            if mx_idx == i:
                continue
            if nums[i] > smx:
                smx = nums[i]
        return (smx - 1) * (mx - 1)


assert 16 == Solution().maxProduct([3, 4, 5, 2, 5])
