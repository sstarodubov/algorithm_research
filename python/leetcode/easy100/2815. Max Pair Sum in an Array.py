from typing import List


class Solution:
    def maxSum(self, nums: List[int]) -> int:
        hm = {}

        def max_digit(n:int):
            d = float("-inf")
            while n:
                d = max(n % 10, d)
                n = n // 10
            return d

        for n in nums:
            d = max_digit(n)
            xs = hm.get(d, [])
            xs.append(n)
            hm[d] = xs

        pairs = []
        for k in hm:
            hm[k].sort(reverse=True)
            if len(hm[k]) >= 2:
                pairs.append((hm[k][0], hm[k][1]))
        if not pairs:
            return -1
        pairs.sort(key=lambda p : p[0] + p[1], reverse=True)
        a, b = pairs[0]
        return a + b



print(Solution().maxSum([2536,1613,3366,162]))