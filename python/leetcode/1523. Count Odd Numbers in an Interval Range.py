class Solution:
    def countOdds(self, low: int, high: int) -> int:
        res = (high - low) // 2
        if low % 2 != 0 or high % 2 != 0:
            res += 1
        return res
