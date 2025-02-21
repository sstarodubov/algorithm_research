from typing import List


class Solution:
    def check(self, nums: List[int]) -> bool:
        if len(nums) <= 1:
            return True

        count = 0

        for i in range(1, len(nums)):
            if nums[i -1] > nums[i]:
                count += 1
            if count == 2:
                return False
        return count == 0 or nums[0] >= nums[-1]

