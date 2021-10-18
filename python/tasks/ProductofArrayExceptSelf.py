from typing import List

"""
Given an integer array nums, return an array answer such that answer[i] is equal 
to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
"""


class Solution:

    # cpu O(n) and space O(n)
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [n for n in nums]
        for i in range(1, len(prefix)):
            prefix[i] *= prefix[i - 1]
        postfix = [n for n in nums]
        for i in range(len(nums) - 2, -1, -1):
            postfix[i] = postfix[i + 1] * postfix[i]

        for i in range(len(nums)):
            if i == 0:
                nums[i] = postfix[i + 1]
            elif i == len(nums) - 1:
                nums[i] = prefix[i - 1]
            else:
                nums[i] = prefix[i - 1] * postfix[i + 1]
        return nums


s = Solution()

assert s.productExceptSelf([1, 2, 3, 4]) == [24, 12, 8, 6], 1
assert s.productExceptSelf([-1, 1, 0, -3, 3]) == [0, 0, 9, 0, 0], 2

print("tests passed")
