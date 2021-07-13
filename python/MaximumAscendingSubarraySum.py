from typing import List

"""
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi < numsi+1. 
Note that a subarray of size 1 is ascending.

"""


class Solution:

    # CPU O(n) and Space O(1)
    def maxAscendingSum(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        curSum = 0
        acc = nums[0]
        for i in range(1, len(nums)):
            if nums[i - 1] < nums[i]:
                acc += nums[i]
                if i == len(nums) - 1:
                    curSum = max(curSum, acc)
            else:
                curSum = max(curSum, acc)
                acc = nums[i]
        return curSum


s = Solution()

assert 65 == s.maxAscendingSum([10, 20, 30, 5, 10, 50]), "1"
assert 150 == s.maxAscendingSum([10, 20, 30, 40, 50]), "2"
assert 33 == s.maxAscendingSum([12, 17, 15, 13, 10, 11, 12]), "3"
assert 100 == s.maxAscendingSum([100, 10, 1]), "4"

print("tests passed")
