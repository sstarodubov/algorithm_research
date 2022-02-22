from collections import defaultdict
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        cur = []
        mp = defaultdict(lambda: 0)

        for ch in paragraph:
            if ch.isalpha():
                cur.append(ch)
            else:
                word = ("".join(cur)).lower()
                mp[word] += 1
                cur.clear()
        if cur:
            word = ("".join(cur)).lower()
            mp[word] += 1

        mx, w = 0, ""
        for k in mp:
            if k and mp[k] > mx and k not in banned:
                w = k
                mx = mp[k]

        return w


assert "ball" == Solution().mostCommonWord("Bob. hIt, baLl", ["bob", "hit"])
assert "bob" == Solution().mostCommonWord("Bob", [])
assert "ball" == Solution().mostCommonWord(paragraph="Bob hit a ball, the hit BALL flew far after it was hit.",
                                           banned=["hit"])
