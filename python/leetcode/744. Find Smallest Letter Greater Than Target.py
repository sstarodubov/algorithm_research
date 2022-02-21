from typing import List


class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        lt, rt = 0, len(letters) - 1

        while lt <= rt:
            m = (lt + rt) // 2
            if ord(letters[m - 1]) <= ord(target) and ord(letters[m]) > ord(target):
                return letters[m]
            if m - 1 < 0:
                return letters[m]
            if ord(letters[m]) <= ord(target):
                lt = m + 1
            elif ord(letters[m]) > ord(target):
                rt = m

        if rt >= len(letters) - 1 and lt >= len(letters) - 1:
            return letters[0]
        return letters[lt]

