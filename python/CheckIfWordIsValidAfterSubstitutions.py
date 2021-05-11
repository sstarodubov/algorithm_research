class Solution:

    # Time O(n) and Space O(n)
    def isValid(self, s: str) -> bool:
        stack: [int] = []
        for letter in s:
            if letter == "c" and len(stack) >= 2:
                pLast = stack[len(stack) - 1]
                ppLast = stack[len(stack) - 2]
                if ppLast == "a" and pLast == "b":
                    stack.pop()
                    stack.pop()
                else:
                    stack.append(letter)
            else:
                stack.append(letter)
        return len(stack) == 0


s = Solution()

assert s.isValid("aabcbc"), "first experience"
assert s.isValid("abcabcababcc"), 2
assert not s.isValid("cababc"), 3

print("tests passed")
