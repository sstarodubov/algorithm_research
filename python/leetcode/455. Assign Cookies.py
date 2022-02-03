from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        ans = 0
        ptr = 0
        for cookie in s:
            if ptr >= len(g):
                return ans
            if cookie >= g[ptr]:
                ans += 1
                ptr += 1

        return ans


assert 1 == Solution().findContentChildren(g=[1, 2, 3], s=[1, 1])
assert 2 == Solution().findContentChildren(g=[1, 2], s=[1, 2, 3])
