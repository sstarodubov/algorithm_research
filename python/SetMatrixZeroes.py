"""
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
You must do it in place.
"""
from typing import List


class Solution:

    # ram O(1) and cpu O(n^3)
    def setZeroes(self, matrix: List[List[int]]) -> None:
        def down(m: [[int]], _x: int, _y: int):
            _y += 1
            while _y < len(m) and m[_y][_x] != 0:
                m[_y][_x] = float("inf")
                _y += 1

        def up(m: [[int]], x: int, y: int):
            y -= 1
            while y >= 0 and m[y][x] != 0:
                m[y][x] = float("inf")
                y -= 1

        def left(m: [[int]], x: int, y: int):
            x -= 1
            while x >= 0 and m[y][x] != 0:
                m[y][x] = float("inf")
                x -= 1

        def right(m: [[int]], x: int, y: int):
            x += 1
            while x < len(m[0]) and m[y][x] != 0:
                m[y][x] = float("inf")
                x += 1

        for y in range(len(matrix)):
            for x in range(len(matrix[0])):
                if matrix[y][x] == 0:
                    up(matrix, x, y)
                    down(matrix, x, y)
                    left(matrix, x, y)
                    right(matrix, x, y)

        for y in range(len(matrix)):
            for x in range(len(matrix[0])):
                if matrix[y][x] == float("inf"):
                    matrix[y][x] = 0


s = Solution()

matrix1 = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
matrix2 = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]

s.setZeroes(matrix2)
s.setZeroes(matrix1)
assert [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]] == matrix2, 1
assert [[1, 0, 1], [0, 0, 0], [1, 0, 1]] == matrix1, 2
print("tests passed")
