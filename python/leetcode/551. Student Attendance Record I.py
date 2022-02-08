class Solution:
    def checkRecord(self, s: str) -> bool:
        A = 0
        L = True
        for i in range(len(s)):
            if s[i] == "A":
                A += 1
            if i + 1 < len(s) and i + 2 < len(s) and s[i] == "L" and s[i + 1] == "L" and s[i + 2] == "L":
                L = False

        return A <= 2 and not L
