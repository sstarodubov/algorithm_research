from typing import List


class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        m = max(nums)
        idx = nums.index(m)
        for i in range(len(nums)):
            if nums[i] != m:
                if nums[i] * 2 <= m:
                    continue
                else:
                    return -1

        return idx