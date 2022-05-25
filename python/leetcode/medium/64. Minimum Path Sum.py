from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = []
        for i in range(len(grid)):
            arr = [-1] * len(grid[0])
            dp.append(arr)

        def dfs(x, y):
            if x == 0 and y == 0:
                return grid[x][y]
            if dp[x][y] != -1:
                return dp[x][y]
            if x < 0 or x >= len(grid):
                return float("inf")
            if y < 0 or y >= len(grid[0]):
                return float("inf")

            sy = dfs(x, y - 1)
            sx = dfs(x - 1, y)
            t = min(sy, sx) + grid[x][y]
            dp[x][y] = t
            return t

        ans = dfs(len(grid) - 1, len(grid[0]) - 1)

        return ans


assert 7 == Solution().minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]])
assert 12 == Solution().minPathSum([[1, 2, 3], [4, 5, 6]])
