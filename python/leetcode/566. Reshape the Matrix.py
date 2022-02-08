from collections import deque
from typing import List


class Solution:

    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        RL, CL = len(mat), len(mat[0])
        if r * c != CL * RL :
            return mat
        m = [[0 for cc in range(c)] for rr in range(r)]
        d = deque([])
        for row in range(RL):
            for col in range(CL):
                d.append(mat[row][col])

        for row in range(len(m)):
            for col in range(len(m[0])):
                cur = d.popleft()
                m[row][col] = cur

        return m


assert Solution().matrixReshape(mat=[[1, 2], [3, 4]], r=2, c=4) == [[1, 2], [3, 4]]
assert Solution().matrixReshape([[1, 2]], 1, 1) == [[1, 2]]
assert Solution().matrixReshape(mat=[[1, 2], [3, 4]], r=1, c=4) == [[1, 2, 3, 4]]
