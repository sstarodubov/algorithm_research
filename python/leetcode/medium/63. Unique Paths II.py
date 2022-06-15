from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        N, M = len(obstacleGrid), len(obstacleGrid[0])
        dp = []

        for _ in range(N):
            dp.append([-1] * M)

        def dfs(x, y):
            if x == 0 and y == 0:
                if obstacleGrid[x][y] == 0:
                    return 1
                else:
                    return 0
            if x < 0 or x >= N:
                return 0
            if y < 0 or y >= M:
                return 0
            if obstacleGrid[x][y] == 1:
                return 0
            if dp[x][y] != -1:
                return dp[x][y]

            tmp = dfs(x - 1, y) + dfs(x, y - 1)
            dp[x][y] = tmp
            return dp[x][y]

        ans = dfs(N - 1, M - 1)

        return ans


assert 0 == Solution().uniquePathsWithObstacles([[1]])
assert 2 == Solution().uniquePathsWithObstacles([[0, 0, 0], [0, 1, 0], [0, 0, 0]])
assert 1 == Solution().uniquePathsWithObstacles([[0, 1], [0, 0]])
