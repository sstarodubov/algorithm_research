from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        x = set()

        for n in nums:
            if n in x:
                return True
            else:
                x.add(n)

        return False

