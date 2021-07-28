
from typing import List


class Solution:
    def removePalindromeSub(self, s):
        return 2 - (s == s[::-1]) - (s == "")

s = Solution()

assert 2 == s.removePalindromeSub("ababb"), 4
assert 2 == s.removePalindromeSub("baabb"), 3
assert 1 == s.removePalindromeSub("ababa"), 1
assert 2 == s.removePalindromeSub("abb"), 2

print("tests passed")
