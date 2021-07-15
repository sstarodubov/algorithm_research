"""
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
"""
from typing import List


class Solution:

    # CPU O(n) and Space O(n)
    def singleNumber(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        m = {}
        for el in nums:
            if el not in m:
                m[el] = True
            else:
                m[el] = False

        for k in m.keys():
            if m[k]: return k


s = Solution()

assert 1 == s.singleNumber([2, 2, 1]), "1"
assert 4 == s.singleNumber([4, 1, 2, 1, 2]), "2"
assert 1 == s.singleNumber([1]), "3"
print("tests passed")
