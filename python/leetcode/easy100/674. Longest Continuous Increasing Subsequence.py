from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        l = 0
        ret = 0
        r = 0
        for i in range(1, len(nums)):
            r = i
            if nums[r] > nums[r - 1]:
                pass
            else:
                ret = max(ret, r - l)
                l = r

        return max(ret, r - l + 1)
