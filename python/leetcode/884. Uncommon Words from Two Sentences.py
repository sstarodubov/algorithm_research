from collections import defaultdict
from typing import List


class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        sm1, sm2 = defaultdict(lambda: 0), defaultdict(lambda: 0)
        for word in s1.split(" "):
            sm1[word] += 1
        for word in s2.split(" "):
            sm2[word] += 1
        ans = []
        for k in sm1:
            if sm1[k] == 1 and k not in sm2:
                ans.append(k)
        for k in sm2:
            if sm2[k] == 1 and k not in sm1:
                ans.append(k)
        return ans


assert Solution().uncommonFromSentences(s1="this apple is sweet", s2="this apple is sour") == ["sweet", "sour"]
assert Solution().uncommonFromSentences("apple apple", "banana") == ["banana"]
