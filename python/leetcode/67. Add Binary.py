from collections import deque


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = a.zfill(len(b))
        b = b.zfill(len(a))
        ptr = len(a) - 1
        carry = 0
        ans = deque([])
        while ptr >= 0:
            s = int(a[ptr]) + int(b[ptr])
            if s == 2 and not carry:
                ans.insert(0, "0")
                carry += 1
            elif s == 2 and carry:
                ans.insert(0, "1")
            elif s == 1 and carry:
                ans.insert(0, "0")
            elif s == 1 and not carry:
                ans.insert(0, "1")
            elif s == 0 and not carry:
                ans.insert(0, "0")
            elif s == 0 and carry:
                ans.insert(0, "1")
                if carry: carry -= 1
            ptr -= 1
        if carry:
            ans.insert(0, "1")
        return "".join(ans)


assert Solution().addBinary(a="11", b="1") == "100"
assert Solution().addBinary(a="1010", b="1011") == "10101"
