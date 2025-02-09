import string


class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        ret = ''
        letters = [''] + list(string.ascii_uppercase)
        while True:
            if columnNumber == 0:
                return ret[::-1]
            m = columnNumber % 26
            if m == 0:
                ret += 'Z'
                columnNumber = (columnNumber // 26) - 1
            else:
                ret += letters[m]
                columnNumber = columnNumber // 26


assert "ZY" == Solution().convertToTitle(701)
assert "AZ" == Solution().convertToTitle(52)
assert 'ABC' == Solution().convertToTitle(731)
assert "AB" == Solution().convertToTitle(28)
assert "A" == Solution().convertToTitle(1)
