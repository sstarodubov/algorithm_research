from collections import defaultdict


class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        d = defaultdict(lambda: 0)

        for letter in t:
            d[letter] += 1

        for letter in s:
            d[letter] -= 1

        for key in d.keys():
            if d[key] == 1:
                return key
        return ""
