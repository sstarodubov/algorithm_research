class Solution:
    def is_div(self, s: str, t: str):
        p = 0
        if not t:
            return True
        for ch in s:
            if p >= len(t):
                p = 0

            if ch != t[p]:
                return False
            p += 1
        return p == len(t)

    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if len(str1) > len(str2):
            big = str1
            small = str2
        else:
            big = str2
            small = str1

        for i in range(len(small), -1, -1):
            d = small[:i]
            if self.is_div(big, d) and self.is_div(small,d):
                return d

        return ""




print(Solution().gcdOfStrings("ABABC", "AB"))
