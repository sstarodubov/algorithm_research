from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        xs = set()
        ans = set()
        for i in range(len(s) - 9):
            x = s[i:i + 10]
            if x in xs:
                ans.add(x)
            xs.add(x)

        return list(ans)


assert ["AAAAAAAAAA"] == Solution().findRepeatedDnaSequences("AAAAAAAAAAA")
assert ["AAAAAAAAAA"] == Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA")
assert ["AAAAACCCCC", "CCCCCAAAAA"] == Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
