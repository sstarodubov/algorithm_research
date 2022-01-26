import string


class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        alpha = {}
        i = 1
        for letter in string.ascii_uppercase:
            alpha[i] = letter
            i += 1

        ans = []
        while columnNumber:
            rest = columnNumber % 26
            if rest != 0:
                columnNumber = columnNumber // 26
                ans.append(alpha[rest])
            else:
                ans.append("Z")
                columnNumber = (columnNumber // 26) - 1
        return "".join(reversed(ans))


assert "AZ" == Solution().convertToTitle(52)
assert "AB" == Solution().convertToTitle(28)
assert "FXSHRXW" == Solution().convertToTitle(2147483647)
