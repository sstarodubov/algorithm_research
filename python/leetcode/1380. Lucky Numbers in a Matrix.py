from typing import List


class Solution:
    def luckyNumbers(self, matrix: List[List[int]]) -> List[int]:
        row_mn = set()

        for row in matrix:
            row_mn.add(min(row))

        col_mx = set()
        for col in range(len(matrix[0])):
            mx = float("-inf")
            for row in range(len(matrix)):
                if mx < matrix[row][col]:
                    mx = matrix[row][col]
            col_mx.add(mx)
        ans = []
        for el in row_mn:
            if el in col_mx:
                ans.append(el)
        return ans


assert [12] == Solution().luckyNumbers([[1, 10, 4, 2], [9, 3, 8, 7], [15, 16, 17, 12]])
assert [15] == Solution().luckyNumbers([[3, 7, 8], [9, 11, 13], [15, 16, 17]])
