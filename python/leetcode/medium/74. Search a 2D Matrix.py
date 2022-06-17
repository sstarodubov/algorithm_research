from typing import List


# time O(n), space O(1)
class Solution:

    def binary_search(self, arr, target):
        l, r = 0, len(arr) - 1

        while l <= r:
            m = (l + r) // 2

            if arr[m] == target:
                return m
            elif target < arr[m]:
                r = m - 1
            else:
                l = m + 1

        return -1

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
        idx = self.binary_search(matrix[r], target)
        if idx == -1:
            return False
        return True


assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=60)
assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=16)
assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=1)
assert Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=3)

assert not Solution().searchMatrix(matrix=[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target=13)
