from typing import List


class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:

        for col in range(len(matrix[0])):
            rr, cc = 0, col
            while rr + 1 < len(matrix) and cc + 1 < len(matrix[0]):
                if matrix[rr][cc] != matrix[rr + 1][cc + 1]:
                    return False
                rr += 1
                cc += 1

        for row in range(len(matrix)):
            rr, cc = row, 0
            while rr + 1 < len(matrix) and cc + 1 < len(matrix[0]):
                if matrix[rr][cc] != matrix[rr + 1][cc + 1]:
                    return False
                rr += 1
                cc += 1

        return True


assert not Solution().isToeplitzMatrix([[1, 2], [2, 2]])
assert Solution().isToeplitzMatrix([[1, 2, 3, 4], [5, 1, 2, 3], [9, 5, 1, 2]])
