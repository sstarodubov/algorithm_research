


class Solution:
    def longestPalindrome(self, s: str) -> str:
        ret = ""
        n = len(s)
        for i in range(n):

            l, r = i, i
            while l >= 0 and r < n and s[l] == s[r]:
                if len(ret) < r - l + 1:
                    ret = s[l: r + 1]
                r += 1
                l -= 1

            l, r = i, i + 1
            while l >= 0 and r < n and s[l] == s[r]:
                if len(ret) < r - l + 1:
                    ret = s[l: r + 1]
                r += 1
                l -= 1
        return ret
