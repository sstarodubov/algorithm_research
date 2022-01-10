class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        rptr = 31
        lptr = 0

        while rptr >= 0:
            cur_bit = (n >> rptr) & 1
            ans = ans | (cur_bit << lptr)
            rptr -= 1
            lptr += 1
        return ans


assert Solution().reverseBits(43261596) == 964176192
print("tests passed")
