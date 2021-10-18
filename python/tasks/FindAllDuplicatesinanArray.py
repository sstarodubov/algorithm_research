from typing import List

"""
Given an integer array nums of length n where all the integers of nums are in the range
 [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
"""


class Solution:

    # cpu O(n) and ram O(1)
    def findDuplicates(self, nums: List[int]) -> List[int]:
        ans = []
        for n in nums:
            key = abs(n) - 1
            if nums[key] < 0:
                ans.append(abs(n))
            nums[key] *= -1

        print(nums)
        return ans


s = Solution()

assert s.findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]) == [2, 3]
print("tests passed")
