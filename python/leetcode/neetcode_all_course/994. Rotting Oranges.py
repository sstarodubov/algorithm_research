from collections import deque
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dq = deque()
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 2:
                    dq.append((r, c, 0))
        ret = 0
        visited = set()
        while dq:
            r, c, d = dq.popleft()
            if (r, c) in visited:
                continue
            grid[r][c] = 2
            ret = max(ret, d)
            visited.add((r, c))
            if r + 1 < len(grid) and grid[r +1][c] == 1:
                dq.append((r + 1, c, d + 1))
            if r - 1 >= 0 and grid[r - 1][c] == 1:
                dq.append((r - 1, c, d + 1))
            if c + 1 < len(grid[0]) and grid[r][c + 1] == 1:
                dq.append((r, c + 1, d + 1))
            if c - 1 >= 0 and grid[r] [c - 1] == 1:
                dq.append((r, c - 1, d + 1))

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    return -1
        return ret

assert 1 == Solution().orangesRotting([[2,2],[1,1],[0,0],[2,0]])
assert -1 == Solution().orangesRotting([[2,1,1],[0,1,1],[1,0,1]])
assert 2 == Solution().orangesRotting([[2,1,1],[1,1,1],[0,1,2]])
assert 0 == Solution().orangesRotting([[0,2]])
assert 4 == Solution().orangesRotting([[2,1,1],[1,1,0],[0,1,1]])