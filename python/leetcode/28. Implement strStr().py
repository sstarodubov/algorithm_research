class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        for i in range(len(haystack) - len(needle)+1):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1


assert Solution().strStr("mississippi", "issip") == 4
assert Solution().strStr("mississippi", "issi") == 1
assert Solution().strStr("aaa", "a") == 0
assert Solution().strStr(haystack="", needle="") == 0
assert Solution().strStr(haystack="aaaaa", needle="bba") == -1
assert Solution().strStr(haystack="hello", needle="ll") == 2
