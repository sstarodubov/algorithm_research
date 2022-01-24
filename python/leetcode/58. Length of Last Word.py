class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        ptr = len(s) - 1
        ans = 0
        while ptr < len(s) and s[ptr] == " ":
            ptr -= 1
        while s[ptr] != " ":
            ptr -= 1
            ans += 1
            if ptr < 0:
                return ans
        return ans

assert 1 == Solution().lengthOfLastWord("a")
assert 5 == Solution().lengthOfLastWord("hello world")
assert 4 == Solution().lengthOfLastWord("   fly me   to   the moon  ")
assert 6 == Solution().lengthOfLastWord("luffy is still joyboy")
