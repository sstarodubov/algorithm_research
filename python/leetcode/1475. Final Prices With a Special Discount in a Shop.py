from typing import List


class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        ans = [-1] * n
        stack = []
        for i in range(n):
            val = prices[i]
            while stack and stack[-1][1] >= val:
                nidx, nval = stack.pop()
                ans[nidx] = val

            stack.append((i, val))

        while stack:
            si, sv =stack.pop()
            ans[si] = -1
        for i in range(n):
            if ans[i] == -1:
                ans[i] = prices[i]
            else:
                ans[i] = prices[i] - ans[i]
        return ans


assert Solution().finalPrices([4, 7, 1, 9, 4, 8, 8, 9, 4]) == [3, 6, 1, 5, 0, 0, 4, 5, 4]

assert Solution().finalPrices([10, 1, 1, 6]) == [9, 0, 1, 6]
assert Solution().finalPrices([8, 4, 6, 2, 3]) == [4, 2, 4, 2, 3]
