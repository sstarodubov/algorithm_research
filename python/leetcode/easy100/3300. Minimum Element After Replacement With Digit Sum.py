from typing import List


class Solution:
    def minElement(self, nums: List[int]) -> int:
        def sum_dig(n:int):
            s = 0
            while n:
               s += n % 10
               n = n // 10
            return s
        ans = float("inf")
        for i in range(len(nums)):
            nums[i] = sum_dig(nums[i])
            ans = min(ans, nums[i])

        return ans