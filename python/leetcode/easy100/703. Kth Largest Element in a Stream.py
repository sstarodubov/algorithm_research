from typing import List
import heapq

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.pq = []
        self.k = k
        for n in nums:
            self.add(n)

    def add(self, val: int) -> int:
        if len(self.pq) < self.k:
            heapq.heappush(self.pq, val)
            return self.pq[0]
        else:
            smallest = self.pq[0]
            if smallest >= val:
                return smallest
            heapq.heappop(self.pq)
            heapq.heappush(self.pq, val)
            return self.pq[0]

KthLargest(3, [4,5,8,2])