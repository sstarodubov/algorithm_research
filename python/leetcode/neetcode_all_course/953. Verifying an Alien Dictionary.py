from typing import List


class Solution:

    def isLess(self, w1, w2):
        l, r = 0, 0

        while l < len(w1) and r < len(w2):
            if self.om[w1[l]] < self.om[w2[r]]:
                return True
            elif self.om[w1[l]] == self.om[w2[r]]:
                l += 1
                r += 1
            else:
                return False

        return len(w1) < len(w2)

    def isAlienSorted(self, words: List[str], order: str) -> bool:
        self.om =  {}
        for i in range(len(order)):
            self.om[order[i]] = i

        for i in range(1, len(words)):
           if self.isLess(words[i], words[i - 1]):
               return False

        return True

assert not Solution().isAlienSorted(words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz")
assert not Solution().isAlienSorted(words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz")
assert  Solution().isAlienSorted(words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz")