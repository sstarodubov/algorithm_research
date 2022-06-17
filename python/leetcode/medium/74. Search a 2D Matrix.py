from typing import List


class Solution:

    #time O(n), space O(1)
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r = len(matrix) - 1
        for row in range(len(matrix)):
            if matrix[row][0] < target:
                continue
            elif matrix[row][0] == target:
                return True
            else:
                r = row - 1
                break
        for col in range(len(matrix[0])):
            if matrix[r][col] == target:
                return True

        return False


assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=1)
assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=60)
assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=16)
assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=3)

assert not Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=13)
