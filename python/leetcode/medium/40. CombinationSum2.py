from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()

        def backtrack(comb: List[int], idx: int):
            s = sum(comb)
            if s == target:
                ans.append(comb[:])
                return
            if s > target:
                return
            for i in range(idx, len(candidates)):
                if i > idx and candidates[i] == candidates[i - 1]:
                    continue
                comb.append(candidates[i])
                backtrack(comb, i + 1)
                comb.pop()

        backtrack([], 0)
        return ans


print(Solution().combinationSum2([1, 1, 2, 3], 5))
print(Solution().combinationSum2([1, 1], 2))
print(Solution().combinationSum2([1], 1))
print(Solution().combinationSum2([1, 2], 4))
print(Solution().combinationSum2(candidates=[10, 1, 2, 7, 6, 1, 5], target=8))
print(Solution().combinationSum2(candidates=[2, 5, 2, 1, 2], target=5))
