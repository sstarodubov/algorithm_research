from collections import defaultdict
from typing import List


class Trie:
    def __init__(self):
        self.root = {"end": False}

    def insert(self, word):
        cur = self.root
        for letter in word:
            if letter not in cur:
                cur[letter] = {"end": False}
            cur = cur[letter]
        cur["end"] = True


class Solution:

    def longestCommonPrefix(self, strs: List[str]) -> str:
        trie = Trie()
        for word in strs:
            trie.insert(word)

        dist = 0
        cur = trie.root
        while len(cur) == 2:
            cur_key = ""
            for key in cur.keys():
                if key == "end":
                    continue
                cur_key = key
            if cur["end"]:
                return strs[0][:dist]
            cur = cur[cur_key]
            dist += 1
        return strs[0][:dist]


assert "a" == Solution().longestCommonPrefix(["a", "ab"])
assert "" == Solution().longestCommonPrefix(["dog", "racecar", "car"])
assert "fl" == Solution().longestCommonPrefix(["flower", "flow", "flight"])
