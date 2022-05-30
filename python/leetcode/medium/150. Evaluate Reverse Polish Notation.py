from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            match token:
                case "+":
                    x = stack.pop()
                    y = stack.pop()
                    stack.append(x + y)
                case "-":
                    x = stack.pop()
                    y = stack.pop()
                    stack.append(y - x)
                case "*":
                    x = stack.pop()
                    y = stack.pop()
                    stack.append(x * y)
                case "/":
                    x = stack.pop()
                    y = stack.pop()

                    stack.append(int(y / x))
                case _:
                    stack.append(int(token))
        return stack[-1]


assert Solution().evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]) == 22
assert Solution().evalRPN(["4", "13", "5", "/", "+"]) == 6
assert Solution().evalRPN(["2", "1", "+", "3", "*"]) == 9
