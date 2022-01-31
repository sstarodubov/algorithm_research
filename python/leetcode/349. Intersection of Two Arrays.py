from collections import defaultdict
from typing import List


class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = []
        d = {x: 0 for x in nums2}
        for el in nums1:
            if el in d and d[el] == 0:
                ans.append(el)
                d[el] += 1
        return ans

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = []
        m = defaultdict(lambda: 0)
        for n in nums2:
            m[n] += 1
        for n in nums1:
            if n in m and m[n] != 0:
                ans.append(n)
                m[n] -= 1
        return ans


assert [4, 9] == Solution().intersect([4, 9, 5], [9, 4, 9, 8, 4])
assert [2] == Solution().intersect([1, 2, 2, 1], [2])
assert [2, 2] == Solution().intersect(nums1=[1, 2, 2, 1], nums2=[2, 2])
assert [2] == Solution().intersection(nums1=[1, 2, 2, 1], nums2=[2, 2])
