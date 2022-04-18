from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        buttons = {"2": ["a", "b", "c"], "3": ["d", "e", "f"], "4": ["g", "h", "i"], "5": ["j", "k", "l"],
                   "6": ["m", "n", "o"], "7": ["p", "q", "r", "s"], "8": ["t", "u", "v"], "9": ["w", "x", "y", "z"]}

        ans = []

        def backtrack(com: List[str], b_idx: int):
            if len(com) == len(digits):
                ans.append("".join(com))
                return
            nums = buttons[digits[b_idx]]
            for i in range(len(nums)):
                com.append(nums[i])
                backtrack(com, b_idx + 1)
                com.pop()

        backtrack([], 0)
        return ans


assert [] == Solution().letterCombinations("")
assert 9 == len(Solution().letterCombinations("23"))
