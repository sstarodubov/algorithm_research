import heapq
from typing import List


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.arr = nums
        heapq.heapify(self.arr)
        self.k = k
        while len(self.arr) > self.k:
            heapq.heappop(self.arr)

    def add(self, val: int) -> int:
        if len(self.arr) < self.k:
            heapq.heappush(self.arr, val)
        else:
            if val > self.arr[0]:
                heapq.heappop(self.arr)
                heapq.heappush(self.arr, val)

        return self.arr[0]
