from typing import List

"""
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, 
and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

"""


class Solution:

    # cpu O(n ^ 3)
    def maxProduct(self, nums: List[int]) -> int:
        result = nums[0]
        for i in range(len(nums)):
            for y in range(i, len(nums)):
                tmp = 1
                for k in range(i, y + 1):
                    tmp = tmp * nums[k]
                result = max(result, tmp)
        return result


s = Solution()
assert 6 == s.maxProduct([2, 3, -2, 4]), 1
assert 0 == s.maxProduct([-2, 0, -1]), 0
print("tests passed")
