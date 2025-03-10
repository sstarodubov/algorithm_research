class Solution:
    def binaryGap(self, n: int) -> int:
        dist = 0
        prev = -1
        for i in range(32):
            bit = n & 1
            if bit:
                if prev == -1:
                    prev = i
                else:
                    dist = max(dist, i - prev)
                    prev = i
            n = n >> 1


        return dist

print(Solution().binaryGap(8))