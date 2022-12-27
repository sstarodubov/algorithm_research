from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        ans = []

        def backtrack(comb=nums, ix=0):
            if ix >= len(nums):
                ans.append(comb[:])
            else:
                for i in range(ix, len(nums)):
                    comb[i], comb[ix] = comb[ix], comb[i]
                    backtrack(comb, ix + 1)
                    comb[i], comb[ix] = comb[ix], comb[i]

        backtrack()
        return ans


print(Solution().permute([1, 2, 3]))
