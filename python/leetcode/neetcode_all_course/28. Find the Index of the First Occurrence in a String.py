class Solution:

    def issame(self, h, s, i):
        if i + len(s) > len(h):
            return False
        l = 0
        for j in range(i, len(h)):
            if l >= len(s):
                return True
            if h[j] == s[l]:
                l += 1
            else:
                return False
        return l == len(s)

    def strStr(self, haystack: str, needle: str) -> int:
        for i in range(len(haystack)):
            if self.issame(haystack, needle, i):
                return i
        return -1


print(Solution().strStr("hello", "a"))