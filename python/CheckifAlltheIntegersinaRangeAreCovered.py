from typing import List

"""
You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents
an inclusive interval between starti and endi.

Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return 
false otherwise.

An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi."""

class Solution:

    # CPU O(n^2) and RAM O(n)
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        m = {}
        for r in ranges:
            for n in range(r[0], r[1] + 1):
                m[n] = True

        for e in range(left, right + 1):
            if e not in m:
                return False
        return True


s = Solution()

assert s.isCovered(ranges=[[1, 2], [3, 4], [5, 6]], left=2, right=5)
assert not s.isCovered([[1, 10], [10, 20]], left=21, right=21)

print("tests passed")
