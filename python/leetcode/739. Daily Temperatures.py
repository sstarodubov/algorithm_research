from typing import List


class Solution:

    # time O(n) , and space O(n)
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0] * len(temperatures)
        stack = []

        for cur_idx in range(len(temperatures)):
            if not stack:
                stack.append(cur_idx)
                continue

            while stack and temperatures[cur_idx] > temperatures[stack[len(stack) - 1]]:
                last_idx = stack.pop()
                diff = cur_idx - last_idx
                ans[last_idx] = diff

            stack.append(cur_idx)

        return ans


assert Solution().dailyTemperatures([30, 60, 90]) == [1, 1, 0]
assert Solution().dailyTemperatures([30, 40, 50, 60]) == [1, 1, 1, 0]
assert Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]) == [1, 1, 4, 2, 1, 1, 0, 0]

print("tests passed")
