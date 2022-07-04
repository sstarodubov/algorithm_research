from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.ans = False
        dp = set()

        def dfs(cur_word: str):
            if self.ans: return

            if cur_word == "":
                self.ans = True
                return

            if cur_word in dp:
                return

            for w in wordDict:
                if cur_word.startswith(w):
                    dfs(cur_word[len(w):])
            dp.add(cur_word)

        dfs(s)
        return self.ans


assert Solution().wordBreak("goalspecial", ["go", "goal", "goals", "special"])
assert Solution().wordBreak("aaaaaaa", ["aaaa", "aaa"])
assert Solution().wordBreak(s="leetcode", wordDict=["leet", "code"])
assert Solution().wordBreak(s="applepenapple", wordDict=["apple", "pen"])
assert not Solution().wordBreak(s="catsandog", wordDict=["cats", "dog", "sand", "and", "cat"])
