from typing import List


class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])

        def dfs(r, c):
            if r < 0 or r >= ROWS:
                return
            if c < 0 or c >= COLS:
                return

            if grid[r][c] != 1:
                return

            grid[r][c] = 2

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for c in range(COLS):
            if grid[0][c] == 1:
                dfs(0, c)
            if grid[ROWS - 1][c] == 1:
                dfs(ROWS - 1, c)

        for r in range(ROWS):
            if grid[r][0] == 1:
                dfs(r, 0)
            if grid[r][COLS - 1]:
                dfs(r, COLS - 1)

        ret = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    ret += 1

        return ret


print(Solution().numEnclaves([[0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0]]))
print(Solution().numEnclaves([[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]]))
