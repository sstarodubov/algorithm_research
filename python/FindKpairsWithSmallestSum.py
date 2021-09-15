from typing import List
import heapq


class El:
    def __init__(self, pair, idx):
        self.sum: int = pair[0] + pair[1]
        self.pair = pair
        self.idx = idx

    def __lt__(self, other):
        return self.sum <= other.sum

    def __gt__(self, other):
        return self.sum > other.sum


class Solution:
    # cpu O(n log n) and ram O(n)
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        ans = []
        if len(nums1) == 0 or len(nums2) == 0 or k == 0:
            return ans
        heap = []
        for i in range(len(nums1)):
            heap.append(El([nums1[i], nums2[0]], 0))
        heapq.heapify(heap)

        i = 1
        while i <= k and len(heap) != 0:
            cur_el = heapq.heappop(heap)
            ans.append(cur_el.pair)
            if cur_el.idx < len(nums2) - 1:
                next = cur_el.idx + 1
                heapq.heappush(heap, El([cur_el.pair[0], nums2[next]], next))
            i += 1
        return ans


s = Solution()

assert s.kSmallestPairs(nums1=[1, 2], nums2=[3], k=3) == [[1, 3], [2, 3]], 3
assert s.kSmallestPairs([1, 1, 2], [1, 2, 3], 10) == [[1, 1], [1, 1], [2, 1], [1, 2], [1, 2], [2, 2], [1, 3], [1, 3],
                                                      [2, 3]], 0
assert s.kSmallestPairs(nums1=[1, 7, 11], nums2=[2, 4, 6], k=3) == [[1, 2], [1, 4], [1, 6]], 1
assert s.kSmallestPairs(nums1=[1, 1, 2], nums2=[1, 2, 3], k=2) == [[1, 1], [1, 1]], 2
print("tests passed")
