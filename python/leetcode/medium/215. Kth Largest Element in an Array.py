import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        hp = []
        for i in range(k):
            heapq.heappush(hp, nums[i])

        for i in range(k, len(nums)):
            if hp[0] < nums[i]:
                heapq.heappop(hp)
                heapq.heappush(hp, nums[i])

        return hp[0]


assert Solution().findKthLargest(nums=[3, 2, 3, 1, 2, 4, 5, 5, 6], k=4) == 4
assert 5 == Solution().findKthLargest(nums=[6, 3, 2, 1, 5, 4], k=2)
