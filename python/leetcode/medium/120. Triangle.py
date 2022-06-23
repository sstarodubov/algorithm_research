from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = {}

        def dfs(row, col, tm):
            if row >= len(triangle):
                return tm
            if col >= len(triangle[row]):
                return float("inf")

            cur_val = triangle[row][col]

            l = dfs(row + 1, col, cur_val + tm)
            r = dfs(row + 1, col + 1, cur_val + tm)
            dp[(row, col)] = min(l, r)
            return dp[(row, col)]

        ans = dfs(0, 0, 0)

        print(ans)
        return ans


assert Solution().minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]) == 11
