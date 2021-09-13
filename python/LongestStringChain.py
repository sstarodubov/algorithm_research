from typing import List


class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        def is_predecessor(cur: str, next: str) -> bool:
            if len(next) - len(cur) != 1:
                return False
            for i in range(len(next)):
                if cur == next[:i] + next[i + 1:]:
                    return True
            return False

        dp = {w: 1 for w in words}

        words.sort(key=len)

        for word in words:
            for key in dp.keys():
                if is_predecessor(key, word):
                    dp[word] = max(dp[key] + 1, dp[word])

        ans = max(list(dp.values()))
        return ans


s = Solution()

assert s.longestStrChain(["a", "ab", "ac", "bd", "abc", "abd", "abdd"]) == 4, 0
assert s.longestStrChain(["a", "b", "ba", "bca", "bda", "bdca"]) == 4, 1
assert s.longestStrChain(["xbc", "pcxbcf", "xb", "cxbc", "pcxbc"]) == 5, 2
assert s.longestStrChain(["abcd", "dbqca"]) == 1, 3

print("tests passed")
