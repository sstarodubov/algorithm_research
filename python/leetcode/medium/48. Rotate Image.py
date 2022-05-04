from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        left, top, right, bottom = 0, 0, len(matrix) - 1, len(matrix) - 1
        step = len(matrix) - 1
        while step > 0:
            for i in range(step):
                x, y = left + i, top
                tmp = matrix[y][x]
                if x + step > right:
                    y = top + (x - left)
                    x = right
                else:
                    x = x + step

                tmp, matrix[y][x] = matrix[y][x], tmp

                if y + step > bottom:
                    x = right - (y - top)
                    y = bottom
                else:
                    y = y + step

                tmp, matrix[y][x] = matrix[y][x], tmp

                if x - step < left:
                    y = bottom - (right - x)
                    x = left
                else:
                    x = x - step
                tmp, matrix[y][x] = matrix[y][x], tmp

                matrix[top][left + i] = tmp
            step -= 2
            top += 1
            left += 1
            right -= 1
            bottom -= 1




Solution().rotate([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]])
