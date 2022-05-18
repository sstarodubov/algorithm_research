class Solution:

    # time O(1) and space O(1)
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        ans = 0
        for i in range(32, -1, -1):
            if (left & (1 << i)) == (right & (1 << i)):
                ans = ans | (left & (1 << i))
            else:
                break
        return ans


assert Solution().rangeBitwiseAnd(5, 7) == 4
assert Solution().rangeBitwiseAnd(left=1, right=2147483647) == 0
assert 0 == Solution().rangeBitwiseAnd(700000000, 2147483641)
assert Solution().rangeBitwiseAnd(0, 0) == 0
