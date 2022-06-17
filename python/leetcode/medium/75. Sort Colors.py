from typing import List


class Solution:
    # time O(n * n)
    def sortColors(self, nums: List[int]) -> None:
        for i in range(len(nums)):
            midx = i
            for j in range(i + 1, len(nums)):
                if nums[midx] > nums[j]:
                    midx = j

            nums[i], nums[midx] = nums[midx], nums[i]




Solution().sortColors([2, 0, 2, 1, 1, 0])

