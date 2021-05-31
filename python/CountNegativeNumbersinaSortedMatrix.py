from typing import List


class Solution:

    # Time O(n^2) Space O(1)
    def countNegatives(self, grid: List[List[int]]) -> int:
        ans = 0
        for i in range(len(grid) - 1, -1, -1):
            for j in range(len(grid[i]) - 1, -1, -1):
                if grid[i][j] >= 0:
                    break
                else:
                    ans += 1
        return ans


s = Solution()

grid = [
    [4, 3, 2, -1],
    [3, 2, 1, -1],
    [1, 1, -1, -2],
    [-1, -1, -2, -3]
]

assert 8 == s.countNegatives(grid), "8"
assert 3 == s.countNegatives([[1, -1], [-1, -1]]), "3"
assert 1 == s.countNegatives([[-1]])
print("tests passed")
