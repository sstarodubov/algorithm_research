from typing import List


class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        prefix = [0] * (len(nums) + 1)
        for i in range(1, len(prefix)):
            prefix[i] = prefix[i - 1] + nums[i - 1]
            nums[i - 1] = prefix[i]
        return nums


assert Solution().runningSum([1, 2, 3, 4]) == [1, 3, 6, 10]
