import math


class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        def num(s:str):
            ret = 0
            p = len(s)
            for ch in s:
                ret += (ord(ch) - 97) * math.pow(10, p)
                p -= 1

            return  ret

        return num(firstWord) + num(secondWord) == num(targetWord)

print(Solution().isSumEqual("j", "j", "bi"))