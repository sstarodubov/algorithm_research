class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = []
        for i in range(m):
            arr = [-1] * n
            dp.append(arr)

        def fn(x, y):
            if x == 0 and y == 0: return 1
            if x >= n or x < 0: return 0
            if y >= m or y < 0: return 0
            if dp[y][x] != -1:
                return dp[y][x]
            ans = fn(x - 1, y) + fn(x, y - 1)
            dp[y][x] = ans
            return ans

        return fn(n - 1, m - 1)


assert 28 == Solution().uniquePaths(m=3, n=7)
assert 3 == Solution().uniquePaths(m=3, n=2)
