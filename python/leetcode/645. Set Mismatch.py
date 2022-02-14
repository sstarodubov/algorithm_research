from collections import defaultdict
from typing import List


class Solution:

    # time O(n) , space O(n)
    def findErrorNums(self, nums: List[int]) -> List[int]:
        m = {}
        for n in nums:
            m[n] = 0
        missed, repeated = 0, 0
        for i in range(len(nums)):
            m[nums[i]] += 1
            if m[nums[i]] == 2:
                repeated = nums[i]
            if i + 1 not in m:
                missed = i + 1
            if repeated and missed:
                return [repeated, missed]
        return []


assert Solution().findErrorNums([8, 7, 3, 5, 3, 6, 1, 4]) == [3, 2]
assert Solution().findErrorNums([1, 2, 2, 4]) == [2, 3]
assert Solution().findErrorNums([2, 2]) == [2, 1]
assert Solution().findErrorNums([3, 2, 2]) == [2, 1]
assert Solution().findErrorNums([1, 1]) == [1, 2]
