from collections import Counter
from typing import List, Set


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        perm = []
        counter = Counter(nums)

        def backtrack():
            if len(perm) == len(nums):
                ans.append(perm[:])
            else:
                for num in counter:
                    if counter[num] > 0:
                        counter[num] -= 1
                        perm.append(num)
                        backtrack()
                        counter[num] += 1
                        perm.pop()

        backtrack()
        return ans


assert Solution().permuteUnique([2, 2, 1, 1]) == [[1, 1, 2, 2], [1, 2, 1, 2], [1, 2, 2, 1], [2, 1, 1, 2], [2, 1, 2, 1],
                                                  [2, 2, 1, 1]]
assert Solution().permuteUnique([1, 1, 1]) == [[1, 1, 1]]
assert Solution().permuteUnique([1, 2, 3]) == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
assert Solution().permuteUnique([1, 1, 2]) == [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
print("tests passed")
