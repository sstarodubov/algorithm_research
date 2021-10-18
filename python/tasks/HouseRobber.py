from typing import List

"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
stashed, the only constraint stopping you from robbing each of them is 
that adjacent houses have security systems connected and it will automatically contact the police 
if two adjacent houses were broken into on thbe same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money
 you can rob tonight without alerting the police.
"""


class Solution:

    # cpu O(n^2) and ram O(1)
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        for i in range(2, len(nums)):
            p = i - 1
            pp = i - 2
            maximum = float("-inf")
            while pp >= 0:
                maximum = max(maximum, max(nums[p], nums[pp] + nums[i]))
                pp -= 1
            nums[i] = maximum

        return max(nums)


s = Solution()

assert s.rob([2, 7, 9, 3, 1]) == 12, 1
assert s.rob([2, 1, 1, 2]) == 4, -1
assert s.rob([1, 2, 3, 1]) == 4, 0

print("tests passed")
