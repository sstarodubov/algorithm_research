class Solution:
    def minLength(self, s: str) -> int:
        stack = []
        for ch in s:
            if len(stack) < 2:
                stack.append(ch)
            else:
                flag = True
                while flag:
                    if len(stack) >= 2 and stack[-1] == "B" and stack[-2] == "A":
                        stack.pop()
                        stack.pop()
                    elif len(stack) >= 2 and stack[-1] == "D" and stack[-2] == "C":
                        stack.pop()
                        stack.pop()
                    else:
                        stack.append(ch)
                        flag = False

        flag = True
        while flag:
            if len(stack) >= 2 and stack[-1] == "B" and stack[-2] == "A":
                stack.pop()
                stack.pop()
            elif len(stack) >= 2 and stack[-1] == "D" and stack[-2] == "C":
                stack.pop()
                stack.pop()
            else:
                flag = False
        return len(stack)

print(Solution().minLength("ABFCACDB"))