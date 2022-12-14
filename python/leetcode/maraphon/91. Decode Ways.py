class Solution:
    def numDecodings(self, s: str) -> int:
        mp = set()
        for i in range(1, 27):
            mp.add(str(i))

        self.ans = 0
        dp = {}

        def dfs(r) -> int:
            if r in dp:
                return dp[r]
            if r == "":
                return 1
            else:
                ans = 0
                if r[:1] in mp:
                    ans += dfs(r[1:])
                if len(r) >= 2 and r[:2] in mp:
                    ans += dfs(r[2:])
                dp[r] = ans
                return ans

        return dfs(s)

assert 3 == Solution().numDecodings("226")
assert 2 == Solution().numDecodings("12")
