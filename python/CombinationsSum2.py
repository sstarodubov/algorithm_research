from typing import List
from collections import Counter


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(comb: List[int], counter):
            s = sum(comb)
            if s == target:
                ar = comb[:]
                ar.sort()
                result.append(ar)
                return
            if s > target:
                return
            for num in counter:
                if counter[num] > 0:
                    comb.append(num)
                    counter[num] -= 1
                    helper(comb, counter)
                    comb.pop()
                    counter[num] += 1

        helper([], Counter(candidates))
        m = {}
        for r in result:
            m[r.__str__()] = r
        return list(m.values())


s = Solution()

r = s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
print(r)

print("tests passed")
