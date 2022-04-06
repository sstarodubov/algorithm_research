from typing import List


class Solution:
    def average(self, salary: List[int]) -> float:
        mx, mn, L = max(salary), min(salary), 0
        ans = 0
        for s in salary:
            if s == mx or s == mn:
                continue
            L+= 1
            ans += s
        return ans / L
