from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        v = [[0 for x in y] for y in grid]

        def dfs(y, x):
            if x >= len(grid[0]) or x < 0:
                return
            if y >= len(grid) or y < 0:
                return

            if v[y][x] == 1:
                return

            v[y][x] = 1

            if grid[y][x] == "0":
                return

            dfs(y + 1, x)
            dfs(y - 1, x)
            dfs(y, x + 1)
            dfs(y, x - 1)

        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if v[i][j] == 0 and grid[i][j] == "1":
                    dfs(i, j)
                    ans += 1
        return ans


assert 1 == Solution().numIslands([
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]
])

assert 3 == Solution().numIslands([
    ["1", "1", "0", "0", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "1", "0", "0"],
    ["0", "0", "0", "1", "1"]
])
