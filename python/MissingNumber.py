from typing import List

"""
Given an array nums containing n distinct numbers in the range [0, n],
 return the only number in the range that is missing from the array.
Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
"""


class Solution:

    # CPU O(n logn) and Ram O(1)
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        if nums[0] == 1:
            return 0
        for i in range(1, len(nums)):
            if (nums[i - 1] + 1) != nums[i]:
                return nums[i - 1] + 1

        return nums[len(nums) - 1] + 1


s = Solution()

assert 2 == s.missingNumber([3, 0, 1]), "1"
assert 2 == s.missingNumber([0, 1]), "2"
assert 8 == s.missingNumber([9, 6, 4, 2, 3, 5, 7, 0, 1]), "3"
assert 1 == s.missingNumber([0]), "4"

print("tests passed")
