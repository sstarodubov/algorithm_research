from typing import List


class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        s = set()
        for n in arr:
            s.add(n)
        zeros = 0
        for n in arr:
            if n == 0:
                zeros += 1
                continue
            if (n * 2) in s:
                return True
        if zeros >= 2:
            return True
        return False


assert Solution().checkIfExist([0, 0])
assert not Solution().checkIfExist([-2, 0, 10, -19, 4, 6, -8])
assert Solution().checkIfExist([10, 2, 5, 3])
