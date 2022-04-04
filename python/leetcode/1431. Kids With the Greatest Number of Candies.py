from typing import List


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        great = max(candies)
        ans = [False] * len(candies)
        for i in range(len(candies)):
            candy = candies[i]
            if candy + extraCandies >= great:
                ans[i] = True
        return ans
