from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        matrix = []
        for _ in range(n):
            matrix.append([-1] * n)

        state = "TL"
        counter = 1
        row, col = 0, 0
        start = 0
        while counter <= (n * n):
            match state:
                case "TL":
                    if col < n and matrix[row][col] == -1:
                        matrix[row][col] = counter
                        col += 1
                        counter += 1
                    else:
                        col -= 1
                        row += 1
                        state = "RT"
                case "RT":
                    if row < n and matrix[row][col] == -1:
                        matrix[row][col] = counter
                        row += 1
                        counter += 1
                    else:
                        row -= 1
                        col -= 1
                        state = "BR"
                case "BR":
                    if col >= 0 and matrix[row][col] == -1:
                        matrix[row][col] = counter
                        col -= 1
                        counter += 1
                    else:
                        col += 1
                        state = "BL"
                        row -= 1
                case "BL":
                    if row >= 0 and matrix[row][col] == -1:
                        matrix[row][col] = counter
                        row -= 1
                        counter += 1
                    else:
                        state = "TL"
                        start += 1
                        row, col = start, start

        return matrix


Solution().generateMatrix(4)
assert Solution().generateMatrix(3) == [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
