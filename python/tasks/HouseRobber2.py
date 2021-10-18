from collections import deque
from typing import List

"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 Meanwhile, adjacent houses have a security system connected,
  and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you 
can rob tonight without alerting the police.

"""


class Solution:

    # cpu O(n) and ram O(n)
    def rob(self, nums: List[int]) -> int:
        d = deque(nums)

        def helper(nums):
            n = len(nums)
            if len(nums) <= 3:
                return max(nums)
            dp = [0] * (n + 1)
            for i in range(2, n + 1):
                dp[i] = max(dp[i - 2] + nums[i - 2], dp[i - 1])
            return dp[-1]

        c1 = helper(d)
        last = d.pop()
        d.appendleft(last)
        c2 = helper(d)
        return max(c1, c2)


s = Solution()

assert s.rob([1, 7, 9, 2]) == 10, 100
assert s.rob([200, 3, 140, 20, 10]) == 340
assert s.rob([1, 1, 1, 2]) == 3, 0
assert s.rob([2, 3, 2]) == 3, 1
assert s.rob([1, 2, 3, 1]) == 4, 2

print("tests passed")
