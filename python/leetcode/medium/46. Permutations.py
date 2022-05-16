from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []

        def backtrack(comb, idx: int):
            if idx >= len(nums):
                ans.append(comb[:])
            else:
                for i in range(idx, len(nums)):
                    comb[i], comb[idx] = comb[idx], comb[i]
                    backtrack(comb, idx + 1)
                    comb[i], comb[idx] = comb[idx], comb[i]

        backtrack(nums, 0)
        return ans


print(Solution().permute([1, 2, 3]))
