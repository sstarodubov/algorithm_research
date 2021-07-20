class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        arr = []
        for i in range(n):
            arr.append(start + (2 * i))

        ans = arr[0]
        for i in range(1, n):
            ans ^= arr[i]
        return ans


s = Solution()

assert s.xorOperation(n=5, start=0) == 8, "1"
assert s.xorOperation(n=4, start=3) == 8, "2"
assert s.xorOperation(n=1, start=7) == 7, "3"
assert s.xorOperation(n=10, start=5) == 2, "4"

print("tests passed")
