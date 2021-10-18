from typing import List


class Solution:

    # cpu O(n) and ram O(u) where u - amount of unique numbers
    def numIdenticalPairs(self, nums: List[int]) -> int:
        ht = {}
        for n in nums:
            if n not in ht:
                ht[n] = [0, 0]
            else:
                ht[n][0] = ht[n][0] + 1
                ht[n][1] = ht[n][0] + ht[n][1]

        ans = 0
        for key in ht:
            ans += ht[key][1]
        return ans


assert Solution().numIdenticalPairs([1, 1, 1, 1]) == 6
assert Solution().numIdenticalPairs([1, 2, 3, 1, 1, 3]) == 4
assert Solution().numIdenticalPairs([1, 2, 3]) == 0
print("tests passed")
