from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        def set_col(col):
            for i in range(len(matrix)):
                if matrix[i][col] is not None:
                    matrix[i][col] = 0

        def set_row(row):
            for i in range(len(matrix[0])):
                if matrix[row][i] is not None:
                    matrix[row][i] = 0

        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    matrix[row][col] = None

        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] is None:
                    set_col(col)
                    set_row(row)

        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] is None:
                    matrix[row][col] = 0


Solution().setZeroes([[1, 2, 3, 4], [5, 0, 7, 8], [0, 10, 11, 12], [13, 14, 15, 0]])
Solution().setZeroes([[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]])
Solution().setZeroes([[1, 1, 1], [1, 0, 1], [1, 1, 1]])
