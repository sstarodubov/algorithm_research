from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        self.ans = 0
        visited = []
        for row in range(len(grid)):
            arr = [0] * len(grid[0])
            visited.append(arr)

        def dfs(row, col):
            if row >= len(grid) or row < 0:
                return
            if col >= len(grid[0]) or col < 0:
                return

            if visited[row][col] == 1:
                return

            if grid[row][col] == 0:
                return

            visited[row][col] = 1
            self.cur += 1

            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if visited[row][col] == 0 and grid[row][col] == 1:
                    self.cur = 0
                    dfs(row, col)
                    self.ans = max(self.ans, self.cur)
        return self.ans


assert 6 == Solution().maxAreaOfIsland(
    [[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
     [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
     [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
     [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]])
