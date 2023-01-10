from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.ans = []
        N = n * 2
        def is_valid(s) -> bool:
            stack = []
            for ch in s:
                if not stack:
                    stack.append(ch)
                else:
                    if stack[-1] == "(" and ch == ")":
                        stack.pop()
                    else:
                        stack.append(ch)
            return len(stack) == 0

        def backtrack(cur=[], l=0):
            if l == N:
                if is_valid(cur):
                    self.ans.append("".join(cur))
            else:
                cur.append(")")
                backtrack(cur, l + 1)
                cur.pop()
                cur.append("(")
                backtrack(cur, l + 1)
                cur.pop()

        cur = []
        backtrack(cur)

        return self.ans


print(Solution().generateParenthesis(2))
