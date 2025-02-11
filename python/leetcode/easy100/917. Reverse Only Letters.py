class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        rev = [""] * len(s)
        for i in range(len(s)):
            if not s[i].isalpha():
                rev[i] = s[i]

        r, w = len(s) - 1, 0

        while r >= 0 and w < len(s):
            while r >= 0 and not s[r].isalpha():
                r -= 1
            while w < len(s) and rev[w]:
                w += 1
            if r < 0 or w >= len(s):
                break
            rev[w] = s[r]
            w += 1
            r -= 1

        return "".join(rev)


print(Solution().reverseOnlyLetters("-"))