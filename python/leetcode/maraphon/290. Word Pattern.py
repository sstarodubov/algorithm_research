class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split(" ")

        if len(pattern) != len(words):
            return False

        m = {}
        mp = {}
        for i in range(len(pattern)):
            w, p = words[i], pattern[i]
            if w not in m and p not in mp:
                m[w] = p
                mp[p] = w
                continue

            if w in m and p in mp:
                if m[w] == p and mp[p] == w:
                    continue
            return False
        return True


assert Solution().wordPattern("abc", "b c a")
assert not Solution().wordPattern("abba", "dog dog dog dog")
assert not Solution().wordPattern("abba", "dog cat cat fish")
assert Solution().wordPattern("abba", "dog cat cat dog")
