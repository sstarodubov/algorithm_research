from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        x, y = 0, 0
        state = "LT"
        left, right, top, bottom = 0, len(matrix[0]) - 1, 0, len(matrix) - 1
        L = len(matrix) * len(matrix[0])
        while len(ans) < L:
            ans.append(matrix[y][x])
            if len(ans) >= L:
                return ans
            match state:
                case "LT":
                    x += 1
                    if x > right:
                        x = right
                        y = top + 1
                        state = "RT"
                case "RT":
                    y += 1
                    if y > bottom:
                        y = bottom
                        x = right - 1
                        state = "RB"
                case "RB":
                    x -= 1
                    if x < left:
                        x = left
                        y = bottom - 1
                        state = "LB"
                case "LB":
                    y -= 1
                    if y <= top:
                        left += 1
                        right -= 1
                        top += 1
                        bottom -= 1
                        state = "LT"
                        x = left
                        y = top
        return ans


assert [1, 2, 3, 6, 9, 8, 7, 4, 5] == Solution().spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
assert [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7] == Solution().spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])
