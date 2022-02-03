class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        if len(s) <= 1: return False

        i = s[0]
        for k in range(len(s)):
            if s[k] != i: break
            if k == len(s) - 1:
                return True

        f, L = 2, len(s)

        while f <= (L // 2):
            if L % f == 0:
                b = L // f
                a = s[:f] * b
                if a == s:
                    return True
            f += 1
        return False


assert Solution().repeatedSubstringPattern("bb")
assert Solution().repeatedSubstringPattern("ababab")
assert Solution().repeatedSubstringPattern("abcabcabcabc")
assert Solution().repeatedSubstringPattern("abab")
assert not Solution().repeatedSubstringPattern("aba")
