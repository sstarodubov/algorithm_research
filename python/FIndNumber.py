"""

Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
"""
from typing import List


class Solution:

    # cpu O (log n) and ram O(1)
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while l <= r:
            m = (l + r) // 2
            if nums[m] == target:
                return m
            elif nums[m] > target:
                r = m - 1
            elif nums[m] < target:
                l = m + 1
        return -1


s = Solution()

assert s.search([1, 2, 3, 4, 5], 1) == 0, 0
assert s.search([1, 2, 3, 4, 5], 5) == 4, 1
assert s.search([1, 2, 3, 4, 5], 3) == 2, 2
assert s.search([1, 2, 3, 4, 5], 10) == -1, 3

print("tests passed")
