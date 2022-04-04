class Solution:
    def maxScore(self, s: str) -> int:
        rones = 0
        for i in range(1, len(s)):
            if s[i] == "1":
                rones += 1

        ans = rones
        lzeros = 0
        for i in range(len(s) - 1):
            if s[i] == "0":
                lzeros += 1
            else:
                if i == 0:
                    continue
                else:
                    rones -= 1
            ans = max(lzeros + rones, ans)

        return ans


assert 1 == Solution().maxScore("00")
assert 3 == Solution().maxScore("1111")
assert 5 == Solution().maxScore("011101")
