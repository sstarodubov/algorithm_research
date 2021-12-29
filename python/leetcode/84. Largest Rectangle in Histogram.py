from typing import List


class Solution:

    # time O(n) , space O(n)
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


assert Solution().largestRectangleArea([2, 7, 6]) == 12
assert Solution().largestRectangleArea([2, 4]) == 4
assert Solution().largestRectangleArea([6, 8, 4, 4, 4, 5, 1, 5]) == 24
assert Solution().largestRectangleArea([2, 1, 5, 6, 2, 3]) == 10
print("tests passed")
