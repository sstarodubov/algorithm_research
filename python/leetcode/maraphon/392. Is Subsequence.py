class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s:
            return True
        s_idx = 0
        for i in range(len(t)):
            if t[i] == s[s_idx]:
                s_idx += 1
            if s_idx == len(s):
                return True

        return False
