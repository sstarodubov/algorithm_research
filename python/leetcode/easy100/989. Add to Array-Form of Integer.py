from typing import List


class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        n = 0
        p = len(num) - 1
        for i in num:
            n += i * pow(10, p)
            p -= 1

        v = n + k
        num.clear()

        while v:
           d  = v % 10
           num.append(d)
           v = v // 10
        num.reverse()

        return num


print(Solution().addToArrayForm(num = [1, 2, 0, 0], k = 1))