from typing import List

"""
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:

Input: n = 1, k = 1
Output: [[1]]

"""


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        arr = [x for x in range(1, n + 1)]
        result = []

        def helper(comb, idx):
            if len(comb) == k:
                result.append(comb[:])
            else:
                for i in range(idx, len(arr)):
                    comb.append(arr[i])
                    helper(comb, i + 1)
                    comb.pop()

        helper([], 0)
        return result


s = Solution()

assert s.combine(4, 2) == [[2, 4], [3, 4], [2, 3], [1, 2], [1, 3], [1, 4]]
print("test passed")
