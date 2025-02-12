from typing import List


class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        loss, rep = 0, 0
        n = len(nums)
        m = set()
        for el in nums:
            if el in m:
                rep = el
            else:
                m.add(el)
        for i in range(1, n + 1):
            if i not in m:
                loss = i
                break

        return [rep, loss]

assert [2, 10] == Solution().findErrorNums([1,5,3,2,2,7,6,4,8,9])
assert [2, 1] == Solution().findErrorNums([3, 2, 2])
assert [3, 2] == Solution().findErrorNums([1, 3, 3])
