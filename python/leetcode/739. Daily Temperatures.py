from typing import List


class Solution:
    # time O(n ^ 2)
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0] * len(temperatures)
        for i in range(len(temperatures)):
            for y in range(i, len(temperatures)):
                if temperatures[y] > temperatures[i]:
                    ans[i] = y - i
                    break
        return ans


assert Solution().dailyTemperatures([30, 60, 90]) == [1, 1, 0]
assert Solution().dailyTemperatures([30, 40, 50, 60]) == [1, 1, 1, 0]
assert Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]) == [1, 1, 4, 2, 1, 1, 0, 0]
print("tests passed")
