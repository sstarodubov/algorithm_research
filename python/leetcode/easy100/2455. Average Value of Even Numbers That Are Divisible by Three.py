from typing import List
class Solution:
    def averageValue(self, nums: List[int]) -> int:
        s = 0
        count = 0

        for n in nums:
            if n % 3 == 0 and n & 1 == 0:
                count += 1
                s += n
        if count == 0:
            return 0
        return s // count