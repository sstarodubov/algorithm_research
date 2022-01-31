from collections import defaultdict


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        d = defaultdict(lambda: 0)
        for l in magazine:
            d[l] += 1

        for r in ransomNote:
            if r not in d:
                return False
            if r in d and d[r] == 0:
                return False
            d[r] -= 1
        return True

assert not Solution().canConstruct(ransomNote = "aa", magazine = "ab")
assert not Solution().canConstruct(ransomNote="a", magazine="b")
assert Solution().canConstruct(ransomNote="aa", magazine="aab")
