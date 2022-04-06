class Solution:
    def makeGood(self, s: str) -> str:
        stack = []
        for ch in s:
            if not stack:
                stack.append(ch)
            else:
                if ((ch.isupper() and stack[-1].islower()) or (ch.islower() and stack[-1].isupper())) and ch.lower() == \
                        stack[-1].lower():
                    stack.pop()
                else:
                    stack.append(ch)
        return "".join(stack)


assert Solution().makeGood("mC") == "mC"
assert Solution().makeGood("abBAcC") == ""
