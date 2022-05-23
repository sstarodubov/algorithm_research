from typing import List


class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        distance = []
        for i in range(n):
            arr = [float("inf")] * n
            distance.append(arr)

        for fr, to, w in edges:
            distance[fr][to] = w
            distance[to][fr] = w

        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if distance[i][k] + distance[k][j] < distance[i][j]:
                        distance[i][j] = distance[i][k] + distance[k][j]

        amount = float("inf")
        city = -1
        for i in range(n):
            x = 0
            for k in range(n):
                if k == i:
                    continue
                v = distance[i][k]
                if v <= distanceThreshold:
                    x += 1

            if x <= amount:
                amount = x
                city = i

        return city


assert 3 == Solution().findTheCity(n=4, edges=[[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]], distanceThreshold=4)
assert 0 == Solution().findTheCity(n=5, edges=[[0, 1, 2], [0, 4, 8], [1, 2, 3], [1, 4, 2], [2, 3, 1], [3, 4, 1]],
                                   distanceThreshold=2)
