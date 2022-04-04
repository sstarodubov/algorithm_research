class Solution:
    def maxScore(self, s: str) -> int:
        ans = 0

        for i in range(1, len(s)):
            lch, rch = 0, 0
            for li in range(0, i):
                if s[li] == '0':
                    lch += 1
            for ri in range(i, len(s)):
                if s[ri] == '1':
                    rch += 1
            ans = max(rch + lch , ans)
        return ans





assert 5 == Solution().maxScore("011101")
