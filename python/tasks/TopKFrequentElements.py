from collections import defaultdict
from typing import List
import heapq

"""
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.
"""


class El:
    def __init__(self, val, freq):
        self.val = val
        self.freq = freq

    def __lt__(self, other):
        return self.freq < other.freq

    def __gt__(self, other):
        return self.freq > other.freq


class Solution:

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        m = defaultdict(int)
        ans = []
        for n in nums:
            m[n] += 1
        arr = [El(k, m[k]) for k in m]

        heapq.heapify(arr)

        while len(arr) > k:
            heapq.heappop(arr)
        for el in arr:
            ans.append(el.val)
        return ans


s = Solution()

assert s.topKFrequent(nums=[10, 10, 9, 9, 5, 6], k=2) == [9, 10]
assert s.topKFrequent(nums=[1, 1, 1, 2, 2, 3], k=2) == [2, 1]
assert s.topKFrequent([-1, -1], 1) == [-1]
assert s.topKFrequent([1], 1) == [1]
print("tests passed")
