import heapq
from typing import List


# time O(n * log n), space O(n)
class Solution:
    def heap_sort(self, nums):
        hp = nums[:]
        heapq.heapify(hp)

        i = 0
        while hp:
            nums[i] = heapq.heappop(hp)
            i += 1

    def sortColors(self, nums: List[int]) -> None:
        self.heap_sort(nums)


Solution().sortColors([2, 0, 2, 1, 1, 0])
