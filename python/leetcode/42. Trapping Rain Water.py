from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 1: return 0
        ans: int = 0
        max_left = [0] * len(height)
        max_right = [0] * len(height)
        for i in range(1, len(height)):
            max_left[i] = max(max_left[i - 1], height[i - 1])
        for i in range(len(height) - 2, -1, -1):
            max_right[i] = max(max_right[i + 1], height[i + 1])

        for i in range(len(height)):
            cur_val = min(max_right[i], max_left[i]) - height[i]
            if cur_val > 0: ans += cur_val

        return ans


assert Solution().trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]) == 6
assert Solution().trap([4, 2, 0, 3, 2, 5]) == 9

print("tests passed")
