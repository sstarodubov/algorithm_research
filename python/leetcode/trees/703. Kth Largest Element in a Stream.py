import heapq
from typing import List


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heap = []
        for n in nums:
            if len(self.heap) < k:
                heapq.heappush(self.heap, n)
            else:
                if n >= self.heap[0]:
                    heapq.heappop(self.heap)
                    heapq.heappush(self.heap, n)

    def add(self, val: int) -> int:
        if len(self.heap) == 0:
            heapq.heappush(self.heap, val)
            return self.heap[0]

        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
        elif val >= self.heap[0]:
            heapq.heappop(self.heap)
            heapq.heappush(self.heap, val)

        return self.heap[0]


ok = KthLargest(2, [0])
print(ok.add(-1))

