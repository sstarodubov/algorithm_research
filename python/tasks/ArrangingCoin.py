class Solution:
    def arrangeCoins(self, n: int) -> int:
        l, r = 0, n
        cur_row: int
        while l < r:
            k = (l + r) // 2
            cur_row = (k * (k + 1)) // 2
            if cur_row == n:
                return k
            if cur_row > n:
                r = k - 1
            else:
                l = k + 1
        return r


s = Solution()

assert 3 == s.arrangeCoins(8)

print("tests passed")
