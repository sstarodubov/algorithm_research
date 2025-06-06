from typing import List


class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        s = set(nums)
        
        while original in s:
            original = original * 2

        return original