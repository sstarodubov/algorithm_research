from typing import List


class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        for row in range(len(image)):
            ptr = len(image[row]) - 1
            for col in range(len(image[0]) // 2):
                image[row][col], image[row][ptr] = image[row][ptr], image[row][col]
                ptr -= 1
        for row in range(len(image)):
            for col in range(len(image[0])):
                image[row][col] ^= 1
        return image


assert Solution().flipAndInvertImage([[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]]) == [[1, 1, 0, 0],
                                                                                                   [0, 1, 1, 0],
                                                                                                   [0, 0, 0, 1],
                                                                                                   [1, 0, 1, 0]]
assert Solution().flipAndInvertImage([[1, 1, 0], [1, 0, 1], [0, 0, 0]]) == [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
