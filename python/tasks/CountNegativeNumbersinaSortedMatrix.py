from typing import List


class Solution:

    # Time O(n * log n) Space O(1)
    def countNegatives(self, grid: List[List[int]]) -> int:
        ans = 0
        for i in range(len(grid) - 1, -1, -1):
            idx = self.indexOfFirstNegative(grid[i])
            if idx == -1:
                continue
            else:
                ans += len(grid[i]) - idx
        return ans

    def indexOfFirstNegative(self, arr: List[int]) -> int:
        l = 0
        r = len(arr) - 1
        m = (l + r) // 2
        while l < r:
            if arr[m] >= 0:
                l = m + 1
            else:
                r = m
            m = (l + r) // 2
        if arr[r] >= 0: return -1
        return r


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
