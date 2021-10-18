from typing import List

"""
Given an integer array nums, handle multiple queries of the following type:

    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int left, int right) Returns the sum of the elements of nums 
    between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
"""


class NumArray:

    # CPU O(n) and RAM O(n)
    def __init__(self, nums: List[int]):
        self.arr = nums
        self.sums: List[int] = [0]
        for n in nums:
            last_sum = self.sums[len(self.sums) - 1]
            self.sums.append(n + last_sum)

    # cpu O(1) and ram O(1)
    def sumRange(self, left: int, right: int) -> int:
        return self.sums[right + 1] - self.sums[left]


num_arr = NumArray([1, 2, 3, 4, 5])

assert num_arr.sumRange(2, 4) == 12
assert num_arr.sumRange(0, 2) == 6

print("tests passed")
