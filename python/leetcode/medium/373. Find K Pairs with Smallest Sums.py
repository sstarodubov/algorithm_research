import heapq


class Solution:
    def kSmallestPairs(self, nums1, nums2, k):
        hp = []

        def append_heap(i, j):
            if i < len(nums1) and j < len(nums2):
                heapq.heappush(hp, [nums1[i] + nums2[j], i, j])

        append_heap(0, 0)
        pairs = []
        while hp and len(pairs) < k:
            _, i, j = heapq.heappop(hp)
            pairs.append([nums1[i], nums2[j]])
            append_heap(i, j + 1)
            if j == 0:
                append_heap(i + 1, 0)
        return pairs


Solution().kSmallestPairs([10, 20, 100], [5, 14, 200], k=3)
Solution().kSmallestPairs(nums1=[2, 4, 6], nums2=[1, 7, 11], k=3)
assert Solution().kSmallestPairs(nums1=[1, 7, 11], nums2=[2, 4, 6], k=3) == [[1, 2], [1, 4], [1, 6]]
