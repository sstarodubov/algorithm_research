from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []

        def backtrack(comb=[], s=0, begin=0):
            if begin >= len(candidates):
                return
            for i in range(begin, len(candidates)):
                s += candidates[i]
                comb.append(candidates[i])
                if s > target:
                    s -= candidates[i]
                    comb.pop()
                    backtrack(comb, s, i + 1)
                    return
                elif s == target:
                    ans.append(comb[:])
                else:
                    backtrack(comb, s, i)

                s -= candidates[i]
                comb.pop()

        backtrack()
        return ans


print(Solution().combinationSum(candidates=[2, 3, 5], target=8))
print(Solution().combinationSum([2, 3, 6, 7], 7))
