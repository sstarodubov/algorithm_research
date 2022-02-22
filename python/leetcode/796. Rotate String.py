class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if goal == s:
            return True

        def shift(st: str):
            return st[1:] + st[0]

        cur = s
        for i in range(len(s)):
            cur = shift(cur)
            if cur == goal:
                return True
        return False


assert Solution().rotateString(s="abcde", goal="cdeab")
