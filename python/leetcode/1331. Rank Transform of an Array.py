import heapq
from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        so = sorted(arr)
        m = {}
        rate = 1
        for i in range(len(so)):
            if so[i] not in m:
                m[so[i]] = rate
                rate += 1
        for i in range(len(arr)):
            arr[i] = m[arr[i]]

        return arr


assert Solution().arrayRankTransform([37, 12, 28, 9, 100, 56, 80, 5, 12]) == [5, 3, 4, 2, 8, 6, 7, 1, 3]
assert Solution().arrayRankTransform([100, 100, 100]) == [1, 1, 1]
assert Solution().arrayRankTransform([40, 10, 20, 30]) == [4, 1, 2, 3]
