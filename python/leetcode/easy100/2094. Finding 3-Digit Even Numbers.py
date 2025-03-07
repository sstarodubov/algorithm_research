from typing import List


class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        ret = set()

        for i in range(len(digits) - 1):
            for j in range(len(digits)):
                for k in range(len(digits)):
                    if i != j and j != k and i != k:
                        d = digits[i] * 100 + digits[j] * 10 + digits[k]
                        if d & 1 == 0 and d >= 100:
                            ret.add(d)

        s = list(ret)
        s.sort()
        return  s

print(Solution().findEvenNumbers([0,2,0,0]))