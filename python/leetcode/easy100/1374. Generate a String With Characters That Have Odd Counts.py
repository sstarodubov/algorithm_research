class Solution:
    def generateTheString(self, n: int) -> str:
        if n == 0:
            return ""

        if n & 1 == 1:
            return "a" * n
        else:
            return ("a" * (n - 1) ) + "b"


print(Solution().generateTheString(7))