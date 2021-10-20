from typing import List


class Solution:

    # cpu O(n^2) and ram O(n)
    def countNicePairs(self, nums: List[int]) -> int:
        def rev(n: int) -> int:
            ans = 0
            while n:
                ans = ans * 10 + (n % 10)
                n = n // 10
            return ans

        table = {}
        for n in nums:
            diff = n - rev(n)
            if diff in table:
                table[diff] += 1
            else:
                table[diff] = 1

        ans = 0
        for k in table:
            ans += ((table[k] - 1) * table[k]) // 2
        return ans % ((10 ** 9) + 7)


assert Solution().countNicePairs([42, 11, 1, 97]) == 2
assert Solution().countNicePairs([13, 10, 35, 24, 76]) == 4
print("tests passed")
