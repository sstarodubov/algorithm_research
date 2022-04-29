from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
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
                comb.append(candidates[i])
                backtrack(comb, i)
                comb.pop()

        backtrack([], 0)
        return ans


assert [[2, 2, 2, 2], [2, 3, 3], [3, 5]] == Solution().combinationSum(candidates=[2, 3, 5], target=8)
assert [[2, 2, 3], [7]] == Solution().combinationSum(candidates=[2, 3, 6, 7], target=7)
