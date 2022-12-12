from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        dp = [[-1 for x in y] for y in obstacleGrid]

        def dfs(n, m):
            if n < 0 or m < 0 or obstacleGrid[m][n] == 1:
                return 0
            if n == 0 and m == 0:
                return 1

            if dp[m][n] != -1:
                return dp[m][n]
            x = dfs(n - 1, m)
            y = dfs(n, m - 1)
            dp[m][n] = x + y
            return dp[m][n]

        ans = dfs(len(obstacleGrid[0]) - 1, len(obstacleGrid) - 1)
        return ans


assert 2 == Solution().uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]])
assert 1 == Solution().uniquePathsWithObstacles([[0, 1], [0, 0]])
