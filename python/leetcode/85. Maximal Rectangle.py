from typing import List


class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        dp: List[int] = [0] * len(matrix[0])
        ans: int = 0
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                cur = int(matrix[row][col])
                if cur:
                    dp[col] += cur
                else:
                    dp[col] = 0
            ans = max(ans, self.largestRectangleArea(dp))
        return ans

    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        ans = 0
        stack = [[0, heights[0]]]
        for i in range(1, len(heights)):
            if not stack:
                stack.append([i, heights[i]])
            else:
                if heights[i] >= stack[len(stack) - 1][1]:
                    stack.append([i, heights[i]])
                else:
                    el = [i, heights[i]]
                    while stack and heights[i] < stack[len(stack) - 1][1]:
                        idx, val = stack.pop()
                        ans = max(ans, val * (i - idx))

                    el[0] = idx
                    stack.append(el)
        last_idx = len(heights) - 1
        for i in range(len(stack)):
            ans = max(ans, ((last_idx - stack[i][0]) + 1) * stack[i][1])

        return ans


assert Solution().maximalRectangle([["0", "1"], ["1", "0"]]) == 1
assert Solution().maximalRectangle(
    [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]) == 6
assert Solution().maximalRectangle([["1"]]) == 1
assert Solution().maximalRectangle([["0"]]) == 0

print("tests passed")
