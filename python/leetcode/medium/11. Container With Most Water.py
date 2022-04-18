from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        L, R = 0, len(height) - 1
        ans = min(height[0], height[1])
        while L <= R:
            ans = max(ans, (R - L) * min(height[L], height[R]))
            if height[L] < height[R]:
                L += 1
            else:
                R -= 1

        return ans


assert Solution().maxArea([4, 3, 2, 1, 4]) == 16
assert Solution().maxArea([1, 1]) == 1
assert Solution().maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]) == 49
