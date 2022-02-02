from collections import deque


class Solution:
    def toHex(self, num: int) -> str:
        if num == 0:
            return "0"
        m = "0123456789abcdef"
        ans = deque([])
        for i in range(8):
            lb = num & 15
            h = m[lb]
            ans.appendleft(h)
            num = num >> 4
        while ans and ans[0] == "0":
            ans.popleft()

        return "".join(ans)


assert Solution().toHex(-1) == "ffffffff"
assert Solution().toHex(3284) == "cd4"
assert Solution().toHex(26) == "1a"
