import heapq
from typing import List


class Obj:
    def __init__(self, val): self.val = val

    def __lt__(self, other): return self.val > other.val

    def __eq__(self, other): return self.val == other.val

    def __str__(self): return self.val


class Solution:

    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        hp = []
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                val = matrix[row][col]
                if len(hp) < k:
                    heapq.heappush(hp, Obj(val))
                else:
                    if hp[0].val > val:
                        heapq.heappop(hp)
                        heapq.heappush(hp, Obj(val))

        return hp[0].val


assert Solution().kthSmallest(matrix=[[-5]], k=1) == -5
assert Solution().kthSmallest(matrix=[[1, 5, 9], [10, 11, 13], [12, 13, 15]], k=8) == 13
