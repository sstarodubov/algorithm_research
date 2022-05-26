from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

        def union(ds, n1, n2):
            if ds[n1] == ds[n2]:
                return

            if len(ds[n1]) < len(ds[n2]):
                for k in ds[n1]:
                    ds[n2].add(k)
                    ds[k] = ds[n2]
            else:
                for k in ds[n2]:
                    ds[n1].add(k)
                    ds[k] = ds[n1]

        disjoint_set = {}

        for n in nums:
            disjoint_set[n] = {n}

        ans = 0
        for n in nums:
            if n + 1 in disjoint_set:
                union(disjoint_set, n + 1, n)
            if n - 1 in disjoint_set:
                union(disjoint_set, n - 1, n)
            ans = max(len(disjoint_set[n]), ans)

        return ans


assert 4 == Solution().longestConsecutive([100, 4, 200, 1, 3, 2])
assert 9 == Solution().longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1])
