class Solution:
    def toLowerCase(self, s: str) -> str:
        ans = []
        for letter in s:
            up = False
            x = ord(letter)
            if 90 >= x >= 65:
                up = True
            if up:
                y = chr(x + 32)
                ans.append(y)
            else:
                ans.append(letter)

        return "".join(ans)


assert "hello" == Solution().toLowerCase("Hello")
assert Solution().toLowerCase("LOVELY") == "lovely"