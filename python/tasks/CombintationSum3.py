from typing import List
from collections import Counter

"""
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

    Only numbers 1 through 9 are used.
    Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice,
and the combinations may be returned in any order.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
"""


class Solution:

    # cpu O(2 ^n ) and ram O(n)
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        result = []

        def helper(comb, idx, counter):
            s = sum(comb)
            if len(comb) == k and s == n:
                ar = comb[:]
                result.append(ar)
                return
            if s > n or len(comb) > k:
                return
            cur_idx = -1
            for num in counter:
                cur_idx += 1
                if cur_idx < idx:
                    continue
                if counter[num] > 0 and num <= 9:
                    comb.append(num)
                    counter[num] -= 1
                    helper(comb, cur_idx, counter)
                    counter[num] += 1
                    comb.pop()

        helper([], 0, Counter([x for x in range(1, n + 1)]))
        return result


s = Solution()

assert [[1, 2, 4]] == s.combinationSum3(k=3, n=7)
assert [] == s.combinationSum3(k=2, n=18)
print("tests passed")
