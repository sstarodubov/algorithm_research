import time


class Solution:

    # cpu O(n^2) and ram O(1)
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        self.longest = [0, 0]

        def is_pol(st, ptr):
            left = ptr - 1
            right = ptr + 1
            while right < len(st) and st[ptr] == st[right]:
                if right - ptr > self.longest[1] - self.longest[0]:
                    self.longest[0] = ptr
                    self.longest[1] = right
                right += 1

            if left == -1 or right >= len(s):
                return

            while left >= 0 and right < len(s):
                if st[left] != st[right]:
                    return
                if right - left > self.longest[1] - self.longest[0]:
                    self.longest[0] = left
                    self.longest[1] = right
                left -= 1
                right += 1

        for ptr in range(len(s)):
            is_pol(s, ptr)
        ans = s[self.longest[0]:self.longest[1] + 1]
        return ans


assert Solution().longestPalindrome("ccc") == "ccc"
assert Solution().longestPalindrome("bb") == "bb"
assert Solution().longestPalindrome("cbbd") == "bb"
assert Solution().longestPalindrome("babad") == "bab"
assert Solution().longestPalindrome("ac") == "a"
assert Solution().longestPalindrome("a") == "a"
print("tests passed")
