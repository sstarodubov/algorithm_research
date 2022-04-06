from typing import List


class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        hs = set(arr)
        cnt = 0
        for i in range(1, 100000000000000000):
            if i not in hs:
                cnt += 1
            if cnt == k:
                return i
        return -1



assert Solution().findKthPositive(arr=[2, 3, 4, 7, 11], k=5) == 9
