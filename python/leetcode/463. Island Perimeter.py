import copy
from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        self.ans = 0

        def dfs(row, col, visited: List[List[int]]):
            if row < 0 or row >= len(grid):
                return
            if col < 0 or col >= len(grid[0]):
                return

            if visited[row][col]:
                return

            visited[row][col] = 1

            if grid[row][col] == 0:
                return

            if row - 1 < 0 or grid[row - 1][col] == 0:
                self.ans += 1
            if col + 1 >= len(grid[0]) or grid[row][col + 1] == 0:
                self.ans += 1
            if row + 1 >= len(grid) or grid[row + 1][col] == 0:
                self.ans += 1
            if col - 1 < 0 or grid[row][col - 1] == 0:
                self.ans += 1

            dfs(row + 1, col, visited)
            dfs(row - 1, col, visited)
            dfs(row, col + 1, visited)
            dfs(row, col - 1, visited)

        visited = [[0 for r in row] for row in grid]

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                dfs(row, col, visited)

        return self.ans


assert 16 == Solution().islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]])
