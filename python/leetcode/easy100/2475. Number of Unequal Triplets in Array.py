from typing import List


class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        r = 0

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                for k in range(j + 1, len(nums)):

                    if nums[i] != nums[j] and nums[i] != nums[k] and nums[j] != nums[k]:
                        r += 1

        return r

