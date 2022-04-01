from collections import defaultdict
from typing import List


class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        def sub(w, s):
            if len(s) > len(w):
                return False
            a = w.find(s)
            return a != -1

        s = set()
        for i in range(len(words)):
            for j in range(len(words)):
                if i == j:
                    continue
                if sub(words[i], words[j]):
                    s.add(words[j])
        return list(s)


assert Solution().stringMatching(["mass", "as", "hero", "superhero"]) == ["as", "hero"]
assert Solution().stringMatching(["leetcode", "et", "code"]) == ["et", "code"]
assert Solution().stringMatching(["eeeet", "eeet"]) == ["eeet"]
assert Solution().stringMatching(["blue", "green", "bu"]) == []
