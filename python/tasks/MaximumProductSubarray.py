from typing import List

"""
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, 
and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

"""


class Solution:

    # cpu O(n)
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        cur_min, cur_max = 1, 1
        for n in nums:
            if n == 0:
                cur_min = 1
                cur_max = 1
            else:
                tmp = cur_max * n
                cur_max = max(n * cur_max, n * cur_min, n)
                cur_min = min(tmp, n * cur_min, n)
                res = max(res, cur_max, cur_min)
        return res


s = Solution()
assert 6 == s.maxProduct([2, 3, -2, 4]), 1
assert 0 == s.maxProduct([-2, 0, -1]), 0

print("tests passed")
