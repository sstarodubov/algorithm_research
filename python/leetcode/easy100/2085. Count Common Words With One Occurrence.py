from typing import List


class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        ret = 0
        m1, m2 = {}, {}
        for w in words1:
            cur = m1.get(w, 0)
            m1[w] = cur + 1
        for w in words2:
            cur = m2.get(w, 0)
            m2[w] = cur + 1
        for w in m1:
            if w in m2 and m2[w] == 1 and m1[w] == 1:
                ret += 1
        return ret
