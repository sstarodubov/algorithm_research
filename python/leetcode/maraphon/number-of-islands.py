from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        rows = len(grid)
        cols = len(grid[0])

        visited = []
        for r in range(rows):
            visited.append([0] * cols)

        def dfs(r, c):
            if r >= rows or r < 0: return
            if c >= cols or c < 0: return
            if visited[r][c]:
                return
            visited[r][c] = 1
            if grid[r][c] == "0":
                return

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for row in range(rows):
            for col in range(cols):
                if not visited[row][col] and grid[row][col] == "1":
                    dfs(row, col)
                    res += 1

        return res


gr = [
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]
]

print(Solution().numIslands(gr))
