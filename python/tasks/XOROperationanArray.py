"""
Given an integer n and an integer start.

Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.
"""


class Solution:

    # CPU O(n) and RAM O(1)
    def xorOperation(self, n: int, start: int) -> int:
        ans: int = start
        for i in range(1, n):
            cur = start + (2 * i)
            ans ^= cur

        return ans


s = Solution()

assert s.xorOperation(n=5, start=0) == 8, "1"
assert s.xorOperation(n=4, start=3) == 8, "2"
assert s.xorOperation(n=1, start=7) == 7, "3"
assert s.xorOperation(n=10, start=5) == 2, "4"

print("tests passed")
