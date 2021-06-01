import math
from typing import List


class Solution:
    # Time O(n) Space O(n)
    def majorityElement(self, nums: List[int]) -> int:
        d = {}
        maj = math.ceil(len(nums) / 2)

        for n in nums:
            if n not in d:
                d[n] = 1
            else:
                d[n] += 1
                if d[n] == maj:
                    return n
        return nums[0]

s = Solution()

assert 2 == s.majorityElement([2, 2, 1, 1, 1, 2, 2]), "2"
assert 3 == s.majorityElement([3, 2, 3]), "3"

print("tests passed")
