from typing import List


class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        ptr = 0
        while ptr < len(arr):
            if arr[ptr] == 0:
                arr.insert(ptr, 0)
                arr.pop()
                ptr += 2
            else:
                ptr += 1


inp = [1, 0, 2, 3, 0, 4, 5, 0]
Solution().duplicateZeros(inp)
print(inp)
assert inp == [1, 0, 0, 2, 3, 0, 0, 4]
