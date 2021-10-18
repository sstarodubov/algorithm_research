from typing import List


class Solution:

    # cpu O(n ^ 2) , ram O(1)
    # def islandPerimeter(self, grid: List[List[int]]) -> int:
    #     ans = 0
    #     for y in range(len(grid)):
    #         for x in range(len(grid[y])):
    #             if grid[y][x] == 1:
    #                 if (x - 1 >= 0 and grid[y][x - 1] == 0) or x - 1 < 0:
    #                     ans += 1
    #                 if (x + 1 < len(grid[y]) and grid[y][x + 1] == 0) or x + 1 == len(grid[y]):
    #                     ans += 1
    #                 if (y + 1 < len(grid) and grid[y + 1][x] == 0) or y + 1 == len(grid):
    #                     ans += 1
    #                 if (y - 1 >= 0 and grid[y - 1][x] == 0) or y - 1 < 0:
    #                     ans += 1
    #     return ans

    # cpu O(n) amortized and ram O(n)
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        self.ans = 0
        visited = {}

        def dfs(y, x):
            if x == len(grid[0]):
                self.ans += 1
                return
            if x < 0:
                self.ans += 1
                return
            if y == len(grid):
                self.ans += 1
                return
            if y < 0:
                self.ans += 1
                return

            if grid[y][x] == 0:
                self.ans += 1
                return
            if (y, x) in visited:
                return
            visited[(y, x)] = True

            dfs(y, x + 1)
            dfs(y, x - 1)
            dfs(y - 1, x)
            dfs(y + 1, x)

        for i in range(len(grid)):
            for y in range(len(grid[i])):
                if grid[i][y] == 1:
                    dfs(i, y)
                    break
        return self.ans


assert Solution().islandPerimeter([[0, 1, 0, 0], [1, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]) == 16

print("tests passed")
