from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            return 0 if nums[0] > nums[1] else 1
        m, lt, rt = 0, 1, len(nums) - 2

        while lt <= rt:
            m = (lt + rt) // 2
            if nums[m] > nums[m - 1] and nums[m] > nums[m + 1]:
                return m
            if nums[m - 1] < nums[m] < nums[m + 1]:
                lt = m + 1
            else:
                rt = m - 1

        if nums[0] >= nums[m] and nums[0] >= nums[-1]:
            return 0
        if nums[m] >= nums[0] and nums[m] >= nums[-1]:
            return m
        return len(nums) - 1


assert 0 == Solution().findPeakElement([2, 1])
assert Solution().findPeakElement([1, 2, 1, 3, 5, 6, 4]) in [2, 5]
assert 2 == Solution().findPeakElement([1, 2, 3, 1])
