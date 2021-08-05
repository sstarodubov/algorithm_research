from typing import List

"""
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's 
in the binary representation of i.

"""


class Solution:

    # cpu O(n ^2) and ram O(n)
    def countBits(self, n: int) -> List[int]:
        ans = [0]

        def count_bits(num: int) -> int:
            count = 0
            while num:
                num = num & (num - 1)
                count += 1
            return count

        for x in range(1, n + 1):
            ans.append(count_bits(x))
        return ans


s = Solution()

assert [0, 1, 1, 2, 1, 2] == s.countBits(5)

print("tests passed")
