class Solution:
    def repeatedCharacter(self, s: str) -> str:
        m = {}
        for ch in s:
            cur = m.get(ch, 0)
            newCur = cur + 1
            m[ch] = newCur

            if newCur == 2:
                return ch
        ""