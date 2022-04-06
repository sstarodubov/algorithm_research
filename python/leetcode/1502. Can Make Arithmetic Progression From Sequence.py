from typing import List


class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        if len(arr) <= 0:
            return True

        arr.sort()
        diff = None
        while arr:
            last = arr.pop()
            if not arr:
                return True
            if diff is None:
                diff = last - arr[-1]
            else:
                if last - arr[-1] != diff:
                    return False
        return True
