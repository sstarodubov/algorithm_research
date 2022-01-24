from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (r + l) // 2
            if nums[m] == target:
                return m
            elif target < nums[m]:
                r = m - 1
            else:
                l = m + 1
        return r + 1


assert Solution().searchInsert(nums=[1, 3, 5, 6], target=7) == 4
assert Solution().searchInsert([1, 3, 5, 6], 0) == 0
assert Solution().searchInsert(nums=[1, 3, 5, 6], target=2) == 1
assert Solution().searchInsert(nums=[1, 3, 5, 6], target=5) == 2
