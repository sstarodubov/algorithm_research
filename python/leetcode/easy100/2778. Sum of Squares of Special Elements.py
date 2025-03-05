from typing import List


class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        ret = 0
        n = len(nums)
        for i in range(n):
            if n % (i + 1)  == 0:
                ret += nums[i] * nums[i]
        return ret

print(Solution().sumOfSquares([2,7,1,19,18,3]))