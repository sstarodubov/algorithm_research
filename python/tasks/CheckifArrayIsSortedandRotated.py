from typing import List

"""
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some 
number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length]
, where % is the modulo operation.

"""


class Solution:

    # CPU O(N) and Ram O(1)
    def check(self, nums: List[int]) -> bool:
        if len(nums) <= 2:
            return True
        flag = False
        for i in range(1, len(nums)):
            if nums[i - 1] > nums[i] and not flag:
                flag = True
            elif nums[i - 1] > nums[i] and flag:
                return False
        return False if flag and nums[0] < nums[len(nums) - 1] else True


s = Solution()
assert s.check([3, 4, 5, 1, 2]), "1"
assert not s.check([2, 1, 3, 4]), "2"
assert s.check([1, 2, 3]), "3"
assert s.check([1, 1, 1]), "4"
assert s.check([2, 1]), "5"

print("tests passed")
