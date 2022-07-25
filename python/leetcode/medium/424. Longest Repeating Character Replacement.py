from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        mp = defaultdict(lambda: 0)

        l, ans = 0, -1

        def is_valid(left, right):
            mx, letter = 0, None
            for key in mp.keys():
                if mp[key] > mx:
                    mx = mp[key]

            return ((right - left + 1) - mx) <= k

        for r in range(len(s)):
            mp[s[r]] += 1
            if not is_valid(l, r):
                mp[s[l]] -= 1
                if mp[s[l]] <= 0:
                    del mp[s[l]]
                l += 1
            else:
                ans = max(ans, r - l + 1)
        return ans


assert Solution().characterReplacement("ABCDE", 1) == 2
assert Solution().characterReplacement("ABAA", 0) == 2
assert Solution().characterReplacement(s="AABABBA", k=1) == 4
assert Solution().characterReplacement("ABAB", 2) == 4
