class Solution:
    def commonFactors(self, a: int, b: int) -> int:
        ret = 0

        if a > b:
            less = b
        else:
            less = a

        for i in range(1, less + 1):
            if a % i == 0 and b % i == 0:
                ret += 1
        return ret