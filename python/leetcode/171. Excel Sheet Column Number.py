import string


class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        alpha = {}

        for i in range(len(string.ascii_uppercase)):
            alpha[string.ascii_uppercase[i]] = i + 1
        ans = 0
        for i in range(len(columnTitle)):
            ans *= 26
            ans += alpha[columnTitle[i]]
        return ans


assert Solution().titleToNumber("FXSHRXW") == 2147483647
assert Solution().titleToNumber("ZY") == 701
