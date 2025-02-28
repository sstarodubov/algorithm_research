from typing import List


class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        arr.sort()
        def count_bit(n:int):
            count = 0

            while n:
                b = n & 1
                if b:
                    count += 1
                n = n >> 1
            return count

        arr.sort(key=count_bit)
        return arr


print(Solution().sortByBits([1024,512,256,128,64,32,16,8,4,2,1]))

