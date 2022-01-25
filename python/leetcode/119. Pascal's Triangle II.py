from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        num = rowIndex + 1
        arr = self.generate(rowIndex + 1)
        return arr[-1]

    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 1: return [[1]]
        if numRows == 2: return [[1], [1, 1]]
        ans = [[1], [1, 1]]
        for i in range(3, numRows + 1):
            tmp = [1] * i
            last_arr = ans[-1]
            for j in range(1, len(tmp) - 1):
                tmp[j] = last_arr[j - 1] + last_arr[j]
            ans.append(tmp)
        return ans
