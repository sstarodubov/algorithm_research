from typing import List


class Solution:
    def is_similar(self, a, b):
        sa = set(a)
        sb = set(b)
        if len(sa) != len(sb):
            return False
        for el in sa:
            if el not in sb:
                return False
        return True

    def similarPairs(self, words: List[str]) -> int:
        ret = 0
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if self.is_similar(words[i], words[j]):
                    ret += 1

        return ret
    
print(Solution().similarPairs(["aba", "aabb", "abcd", "bac", "aabc"]))
