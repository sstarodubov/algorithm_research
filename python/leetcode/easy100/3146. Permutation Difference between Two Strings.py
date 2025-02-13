class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        ms, mt, n = {}, {}, len(t)

        for i in range(n):
            ms[s[i]] = i
            mt[t[i]] = i

        ret = 0

        for ks in ms:
           ret += abs(ms[ks] - mt[ks])

        return ret