from collections import defaultdict


class Solution:
    def longestPalindrome(self, s: str) -> int:
        m = defaultdict(lambda: 0)
        ans, used = 0, False
        for ch in s:
            m[ch] += 1
        for k in m:
            if m[k] & 1 == 0:
                ans += m[k]
            else:
                used = True
                ans += m[k] - 1

        if used:
            ans += 1
        return ans

assert 2 == Solution().longestPalindrome("bb")
assert 1 == Solution().longestPalindrome("a")
assert 7 == Solution().longestPalindrome("abccccdd")
