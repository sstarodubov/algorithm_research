class TwoSet:
    def __init__(self):
        self.s1 = set()
        self.s2 = set()

    def is_ok_to_add(self, v):
        if v in self.s1 and v in self.s2:
            return False
        return True

    def add(self, v):
        if v not in self.s1:
            self.s1.add(v)
        else:
            self.s2.add(v)

    def remove(self, v):
        if v in self.s1:
            self.s1.remove(v)
        else:
            if v in self.s2:
                self.s2.remove(v)
    def size(self):
        return len(self.s2) + len(self.s1)


class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        l, r, ans, m = 0, 1, 1, {}
        s = "$" + s
        ts = TwoSet()
        for r in range(1, len(s)):
            next_ch = s[r]
            if ts.is_ok_to_add(next_ch):
                ts.add(next_ch)
            else:
                while s[l] != s[r]:
                    ts.remove(s[l])
                    l+=1
                ts.remove(s[l])
                ts.add(next_ch)
                l += 1
            ans = max(ans, ts.size())
        return ans

assert 2 == Solution().maximumLengthSubstring("aaaaa")
assert 4 == Solution().maximumLengthSubstring("ccbcb")
assert 4 == Solution().maximumLengthSubstring("aadaad")
assert 4 == Solution().maximumLengthSubstring("bcbbbcba")
