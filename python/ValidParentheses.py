class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for letter in s:
            if not stack:
                stack.append(letter)
            else:
                last = stack[len(stack) - 1]
                if last == "(" and letter == ")":
                    stack.pop()
                elif last == "{" and letter == "}":
                    stack.pop()
                elif last == "[" and letter == "]":
                    stack.pop()
                else:
                    stack.append(letter)
        return len(stack) == 0


s = Solution()
assert s.isValid("()[]{}"), "2"
assert s.isValid("()"), "1"
assert not s.isValid("(("), "1"
print("tests passed")
