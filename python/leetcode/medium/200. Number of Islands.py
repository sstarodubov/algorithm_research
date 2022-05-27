from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ans = 0
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

            if grid[row][col] == '0':
                return

            visited[row][col] = 1

            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if visited[row][col] == 0 and grid[row][col] == "1":
                    dfs(row, col)
                    ans += 1
        return ans


assert Solution().numIslands(grid=[
    ["1", "1", "0", "0", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "1", "0", "0"],
    ["0", "0", "0", "1", "1"]
]) == 3

assert  1 == Solution().numIslands(grid=[
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]
])
