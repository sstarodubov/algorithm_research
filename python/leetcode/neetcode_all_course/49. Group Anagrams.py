from typing import List


class Solution:

    def get_key(self, s: str) -> str:
        return "".join(sorted(s))

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ret = []
        hm = {}
        for s in strs:
            k = self.get_key(s)
            if k in hm:
                hm[k].append(k)
            else:
                hm[k] = [s]

        for k in hm:
            ret.append(hm[k])

        return ret
