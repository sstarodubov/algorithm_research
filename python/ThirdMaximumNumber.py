"""
Given integer array nums, return the third maximum number in this array. If the third maximum does not exist,
 return the maximum number.
"""
from typing import List


class Solution:

    # CPU O(n log n) and RAM O(1)
    def thirdMax(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]
        nums.sort(reverse=True)
        count = 1
        _max = nums[0]
        for i in range(1, len(nums)):
            if count == 3: return _max
            if _max != nums[i]:
                _max = nums[i]
                count += 1
        if count != 3:
            return max(nums)
        return _max


s = Solution()

assert 2 == s.thirdMax([1, 1, 2]), "4"
assert 2 == s.thirdMax(nums=[1, 2]), "2"
assert 1 == s.thirdMax(nums=[3, 2, 1]), "1"
assert 1 == s.thirdMax([2, 2, 3, 1]), "3"
print("test passed")
