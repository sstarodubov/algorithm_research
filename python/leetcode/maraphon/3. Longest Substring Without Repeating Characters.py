class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, map, ans = 0, {}, 0
        for r in range(len(s)):
            if s[r] in map and map[s[r]] >= l:
                l = map[s[r]] + 1
            map[s[r]] = r
            ans = max(ans, r - l + 1)
        return ans


assert 3 == Solution().lengthOfLongestSubstring("pwwkew")
assert 2 == Solution().lengthOfLongestSubstring("abba")
assert 1 == Solution().lengthOfLongestSubstring("bbbbb")
assert 5 == Solution().lengthOfLongestSubstring("abcdgck")
assert 3 == Solution().lengthOfLongestSubstring("abcabcbb")
