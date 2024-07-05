class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        buf = set()
        ret = 0

        l, r = 0, 0

        while r < len(s):
            if s[r] not in buf:
                buf.add(s[r])
            else:
                ret = max(ret, r - l)
                while s[l] != s[r]:
                    buf.remove(s[l])
                    l += 1
                l += 1
            r += 1
        return max(ret, r - l)

print(Solution().lengthOfLongestSubstring("abcbbccab"))

