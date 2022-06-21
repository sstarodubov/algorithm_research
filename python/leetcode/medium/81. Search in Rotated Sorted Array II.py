from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        for n in nums:
            if n == target:
                return True

        return False
