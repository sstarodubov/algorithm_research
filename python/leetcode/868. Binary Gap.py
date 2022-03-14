class Solution:
    def binaryGap(self, n: int) -> int:
        ptr, b = -1, 0
        while not b:
            ptr += 1
            if ptr > 32:
                return 0
            b = (n >> ptr) & 1
        ans = 0
        for nxt in range(ptr + 1, 32):
            bn = (n >> nxt) & 1
            if bn:
                ans = max(ans, nxt - ptr)
                ptr = nxt

        return ans


assert Solution().binaryGap(5) == 2
assert Solution().binaryGap(8) == 0
assert Solution().binaryGap(22) == 2
