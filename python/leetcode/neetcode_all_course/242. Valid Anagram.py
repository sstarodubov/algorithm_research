class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        hm = {}

        for c in s:
            if c in hm:
                hm[c] += 1
            else:
                hm[c] = 1

        for c in t:
            if c in hm:
                hm[c] -= 1
            else:
                return False

        for k in hm:
            if hm[k] != 0:
                return False

        return True
