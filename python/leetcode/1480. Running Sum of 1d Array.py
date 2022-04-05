from typing import List


class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        cur, prev = 0, 0
        for i in range(1, len(nums) + 1):
            cur = prev + nums[i - 1]
            nums[i - 1] = cur
            prev = cur
        return nums


assert Solution().runningSum([1, 2, 3, 4]) == [1, 3, 6, 10]
