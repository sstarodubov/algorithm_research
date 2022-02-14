from collections import defaultdict
from typing import List


class Solution:

    # time O(n * log n) , space O(1)
    def findErrorNums(self, nums: List[int]) -> List[int]:
        nums.sort()
        cs = sum(nums)
        rs = 0

        for i in range(1, len(nums) + 1):
            rs += i
        repeated = 0

        for i in range(1, len(nums)):
            if nums[i] ^ nums[i - 1] == 0:
                repeated = nums[i]
                break
        return [repeated, repeated + (rs - cs)]


assert Solution().findErrorNums([8, 7, 3, 5, 3, 6, 1, 4]) == [3, 2]
assert Solution().findErrorNums([1, 2, 2, 4]) == [2, 3]
assert Solution().findErrorNums([2, 2]) == [2, 1]
assert Solution().findErrorNums([3, 2, 2]) == [2, 1]
assert Solution().findErrorNums([1, 1]) == [1, 2]
