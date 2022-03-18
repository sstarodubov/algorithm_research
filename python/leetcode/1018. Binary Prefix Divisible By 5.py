from typing import List


class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        x = 0
        ans = []
        for bit in nums:
            x = x | bit
            if x % 5 == 0:
                ans.append(True)
            else:
                ans.append(False)
            x = x << 1
        return ans


assert [False, False, False] == Solution().prefixesDivBy5([1, 1, 1])
assert [True, False, False] == Solution().prefixesDivBy5([0, 1, 1])
