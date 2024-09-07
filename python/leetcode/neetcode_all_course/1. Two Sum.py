from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        for i in range(len(nums)):
            n = nums[i]
            op = target - n
            
            if op in hm:
                return [i, hm[op]]
            else:
                hm[n] = i

        return [-1, -1]

