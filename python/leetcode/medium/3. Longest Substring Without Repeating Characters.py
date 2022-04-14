from collections import deque


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        window = deque([s[0]])
        ans, hm = 1, set()
        hm.add(s[0])
        for rp in range(1, len(s)):
            if s[rp] in hm:
                while True:
                    cur = window.popleft()
                    hm.remove(cur)
                    if s[rp] == cur:
                        break

            window.append(s[rp])
            hm.add(s[rp])
            ans = max(ans, len(window))
        return ans


assert 1 == Solution().lengthOfLongestSubstring(" ")
assert 0 == Solution().lengthOfLongestSubstring("")
assert 3 == Solution().lengthOfLongestSubstring("pwwkew")
assert 1 == Solution().lengthOfLongestSubstring("bbbbb")
assert 3 == Solution().lengthOfLongestSubstring("abcabcbb")
