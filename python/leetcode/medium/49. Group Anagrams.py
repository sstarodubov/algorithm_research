from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = defaultdict(lambda: [])

        for string in strs:
            key = "".join(sorted(string))
            hm[key].append(string)

        ans = []

        for k in hm:
            ans.append(hm[k])

        return ans


assert [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]] == Solution().groupAnagrams(
    ["eat", "tea", "tan", "ate", "nat", "bat"])
