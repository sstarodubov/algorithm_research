class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split(" ")
        if len(words) != len(pattern):
            return False
        d = {}
        ptr = 0
        used = set()
        for word in words:
            if pattern[ptr] not in d:
                if word in used:
                    return False
                d[pattern[ptr]] = word
                used.add(word)
            else:
                if d[pattern[ptr]] != word:
                    return False
            ptr += 1
        return True


assert not Solution().wordPattern("abba", "dog dog dog dog")
assert Solution().wordPattern("abba", "dog cat cat dog")
assert not Solution().wordPattern(pattern="abba", s="dog cat cat fish")
assert not Solution().wordPattern(pattern="aaaa", s="dog cat cat dog")
