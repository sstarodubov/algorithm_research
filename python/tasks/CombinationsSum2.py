from typing import List
from collections import Counter


class Solution:

    # cpu O(2 ^n ) and ram O(n)
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(comb: List[int], idx, counter):
            s = sum(comb)
            if s == target:
                ar = comb[:]
                result.append(ar)
                return
            if s > target:
                return
            cur_idx = -1
            for num in counter:
                cur_idx += 1
                if cur_idx < idx:
                    continue

                if counter[num] > 0:
                    comb.append(num)
                    counter[num] -= 1
                    helper(comb, cur_idx, counter)
                    comb.pop()
                    counter[num] += 1

        helper([], 0, Counter(candidates))
        return result


s = Solution()

r = s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
print(r)

print("tests passed")
