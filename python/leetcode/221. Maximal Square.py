from typing import List


class Solution:

    # time O(n ^ 3), space O(col)
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        ans = 0
        dp = [0] * len(matrix[0])
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                cur = int(matrix[row][col])
                if cur:
                    dp[col] += cur
                else:
                    dp[col] = 0

            for i in range(len(dp)):
                h = dp[i]
                b = 1
                if not h:
                    continue
                cur = i + 1
                while cur < len(dp) and b < h:
                    if dp[cur] == 0:
                        break
                    h = min(h, dp[cur])
                    b += 1
                    cur += 1
                if b > h:
                    b = h
                ans = max(ans, b)

        return ans * ans


assert Solution().maximalSquare(
    [["1", "1", "1", "1", "0"], ["1", "1", "1", "1", "0"], ["1", "1", "1", "1", "1"], ["1", "1", "1", "1", "1"],
     ["0", "0", "1", "1", "1"]]) == 16

assert Solution().maximalSquare(
    [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]) == 4

assert Solution().maximalSquare(
    [["1", "0", "1", "0"], ["1", "0", "1", "1"], ["1", "0", "1", "1"], ["1", "1", "1", "1"]]) == 4

assert Solution().maximalSquare([["0", "1"], ["0", "1"]]) == 1

assert Solution().maximalSquare([["0", "1"], ["1", "0"]]) == 1
