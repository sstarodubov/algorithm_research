from typing import List

"""
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA 
without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.
"""


class Solution:

    # cpu O(n^4) and ram O(n)
    def longestStrChain(self, words: List[str]) -> int:
        def is_predecessor(cur: str, next: str) -> bool:
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
