from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = {}

        def dfs(row, col):
            t = (row, col)
            if t in dp:
                return dp[t]

            cur_val = triangle[row][col]

            if row + 1 >= len(triangle):
                return cur_val

            l = dfs(row + 1, col)
            r = dfs(row + 1, col + 1)

            tmp = cur_val + min(l, r)
            dp[t] = tmp
            return tmp

        ans = dfs(0, 0)

        return ans


assert Solution().minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]) == 11
