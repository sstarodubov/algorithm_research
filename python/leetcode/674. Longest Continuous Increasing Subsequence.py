from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:

        ans, lt, rt = 1, 0, 0
        while True:
            rt += 1
            if rt >= len(nums):
                return max(ans, rt - lt)
            if rt - 1 >= 0 and nums[rt] <= nums[rt - 1]:
                ans = max(ans, rt - lt)
                lt = rt


assert 3 == Solution().findLengthOfLCIS([1, 3, 5, 4, 7])
assert 1 == Solution().findLengthOfLCIS([2, 2, 2, 2, 2])
