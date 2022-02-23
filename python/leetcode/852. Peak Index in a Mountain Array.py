from typing import List


class Solution():
    def peakIndexInMountainArray(self, A: List[int]):
        lt, rt = 0, len(A) - 1
        while lt < rt:
            mi = (lt + rt) // 2
            if A[mi] < A[mi + 1]:
                lt = mi + 1
            else:
                rt = mi
        return lt


assert Solution().peakIndexInMountainArray([0, 10, 5, 2, 1, 0]) == 1
