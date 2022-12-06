from typing import List


class Solution:

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        phone = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }

        ans = []

        def dfs(comb=[], begin=0):
            if begin >= len(digits):
                ans.append("".join(comb))
                return
            for i in range(len(phone[digits[begin]])):
                comb.append(phone[digits[begin]][i])
                dfs(comb, begin + 1)
                comb.pop()

        dfs()

        return ans


assert Solution().letterCombinations("23") == ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
