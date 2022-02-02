import heapq
from collections import deque
from typing import List


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)
        nums.sort(reverse=True)
        ans = nums[0]
        counter = 1
        for i in range(1, len(nums)):
            if counter == 3:
                return ans
            if ans != nums[i]:
                counter += 1
                ans = nums[i]
        mx = float("-inf")
        if counter == 2:
            for n in nums:
                mx = max(mx, n)
            return mx
        return ans


assert Solution().thirdMax([1, 1, 2]) == 2
assert Solution().thirdMax([3, 2, 1]) == 1
assert Solution().thirdMax([1, 2]) == 2
assert Solution().thirdMax([2, 2, 3, 1]) == 1
