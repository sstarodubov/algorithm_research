from typing import List


class Solution:

    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        s, i = [], 0

        for v in pushed:
            s.append(v)
            while s and i < len(popped) and popped[i] == s[-1]:
                i += 1
                s.pop()

        return len(s) == 0 and i == len(popped)

print(Solution().validateStackSequences(pushed = [1,2,3,4,5], popped = [4,3,5,1,2]))
print(Solution().validateStackSequences(pushed = [1,2,3,4,5], popped = [4,5,3,2,1]))
