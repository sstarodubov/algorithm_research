from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def is_valid(braces: List[str]) -> bool:
            stack = []
            for brace in braces:
                if not stack:
                    stack.append(brace)
                else:
                    if stack[-1] == "(" and brace == ")":
                        stack.pop()
                    else:
                        stack.append(brace)
            return len(stack) == 0

        ans = []

        def backtrack(comb: List[str]):
            if len(comb) == (n * 2):
                if is_valid(comb):
                    ans.append("".join(comb))
                return
            else:
                comb.append("(")
                backtrack(comb)
                comb.pop()
                comb.append(")")
                backtrack(comb)
                comb.pop()

        backtrack([])
        return ans


assert ["()"] == Solution().generateParenthesis(1)
assert ["((()))", "(()())", "(())()", "()(())", "()()()"] == Solution().generateParenthesis(3)
