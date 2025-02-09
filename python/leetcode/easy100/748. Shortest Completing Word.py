from typing import List


class Solution:
    def build_map(self, word: str):
        m = {}
        for s in word:
            if s.isalpha():
                l = s.lower()
                if l in m:
                    m[l] += 1
                else:
                    m[l] = 1
        return m

    def m_in_m(self, m1, m2):
        for k in m1:
            if k not in m2:
                return False
            else:
                if m2[k] < m1[k]:
                    return False

        return True

    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        lm = self.build_map(licensePlate)
        ret = "1" * 20
        for word in words:
            if len(word) < len(ret):
                t = self.build_map(word)
                if self.m_in_m(lm, t):
                    ret = word

        return ret
