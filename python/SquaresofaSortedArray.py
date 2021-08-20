"""
Given an integer array nums sorted in non-decreasing order, return an array of the squares
of each number sorted in non-decreasing order.
"""
from collections import deque
from typing import List


class Solution:

    # cpu O(n log n) and ram O(1)
    # def sortedSquares(self, nums: List[int]) -> List[int]:
    #     for i in range(len(nums)):
    #         nums[i] *= nums[i]
    #     nums.sort()
    #     return nums

    # cpu O(n) and ram O(n)
    def sortedSquares(self, nums: List[int]) -> List[int]:
        q = deque([])
        l, r = 0, len(nums) - 1

        while l <= r:
            if abs(nums[l]) > abs(nums[r]):
                q.appendleft(nums[l] * nums[l])
                l += 1
            else:
                q.appendleft(nums[r] * nums[r])
                r -= 1
        return list(q)


s = Solution()

assert s.sortedSquares([-4, -1, 0, 3, 10]) == [0, 1, 9, 16, 100]
assert s.sortedSquares([-7, -3, 2, 3, 11]) == [4, 9, 9, 49, 121]

print("tests passed")
