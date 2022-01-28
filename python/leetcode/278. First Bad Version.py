def isBadVersion(m):
    if m >= 6:
        return True
    else:
        return False


class Solution:
    def firstBadVersion(self, n: int) -> int:
        l, r = 1, n
        while l <= r:
            m = (l + r) // 2
            if not isBadVersion(m):
                l = m + 1
            else:
                r = m - 1
        if isBadVersion(r):
            return r
        else:
            return l


assert Solution().firstBadVersion(8) == 6
assert Solution().firstBadVersion(11) == 6
assert Solution().firstBadVersion(9) == 6
