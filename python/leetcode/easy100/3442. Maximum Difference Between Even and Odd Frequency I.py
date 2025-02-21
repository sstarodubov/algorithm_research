class Solution:
    def maxDifference(self, s: str) -> int:
        m = {}
        for ch in s:
            cur = m.get(ch, 0)
            m[ch] = cur + 1
        odd = float("-inf")
        even = float("inf")
        for k in m:
            if m[k] & 1 == 1:
                odd = max(odd, m[k])
            else:
                even = min(even, m[k])

        return odd - even