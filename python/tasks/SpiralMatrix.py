from typing import List

"""
Given an m x n matrix, return all elements of the matrix in spiral order
"""


class Solution:

    # ram O(n) and cpu O(m * n)
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        # (x, y)
        map = {
            "tl": (0, 0),
            "bl": (0, len(matrix) - 1),
            "br": (len(matrix[0]) - 1, len(matrix) - 1),
            "tr": (len(matrix[0]) - 1, 0)
        }

        while True:
            x, y = map["tl"]
            while x <= map["tr"][0]:
                if len(ans) == len(matrix) * len(matrix[0]):
                    return ans
                ans.append(matrix[y][x])
                x += 1
            x, y = map["tr"]
            y += 1
            if len(ans) == len(matrix) * len(matrix[0]):
                return ans
            while y <= map["br"][1]:
                if len(ans) == len(matrix) * len(matrix[0]):
                    return ans
                ans.append(matrix[y][x])
                y += 1
            if len(ans) == len(matrix) * len(matrix[0]):
                return ans
            x, y = map["br"]
            x -= 1
            while x >= map["bl"][0]:
                if len(ans) == len(matrix) * len(matrix[0]):
                    return ans
                ans.append(matrix[y][x])
                x -= 1
            if len(ans) == len(matrix) * len(matrix[0]):
                return ans
            x, y = map["bl"]
            y -= 1
            while y > map["tl"][1]:
                if len(ans) == len(matrix) * len(matrix[0]):
                    return ans
                ans.append(matrix[y][x])
                y -= 1
            if len(ans) == len(matrix) * len(matrix[0]):
                return ans
            map["tl"] = (map["tl"][0] + 1, map["tl"][1] + 1)
            map["tr"] = (map["tr"][0] - 1, map["tr"][1] + 1)
            map["br"] = (map["br"][0] - 1, map["br"][1] - 1)
            map["bl"] = (map["bl"][0] + 1, map["bl"][1] - 1)


s = Solution()

assert s.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]) == [1, 2, 3, 4, 8, 12, 16, 15, 14,
                                                                                          13, 9, 5, 6, 7, 11, 10]
# assert s.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]) == [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

print("tests passed")
