import heapq
from collections import defaultdict
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dist = [float("inf")] * n
        dist[src] = 0
        ans = float("inf")
        for k in range(k + 1):
            tmp = dist.copy()
            for cur_node, other_node, w in flights:
                if dist[cur_node] == float("inf"):
                    continue
                if dist[cur_node] + w < tmp[other_node]:
                    tmp[other_node] = dist[cur_node] + w
            dist = tmp

        return -1 if dist[dst] == float("inf") else dist[dst]


assert Solution().findCheapestPrice(5, [[0, 1, 5], [1, 2, 5], [0, 3, 2], [3, 1, 2], [1, 4, 1], [4, 2, 1]], 0, 2, 2) == 7
assert Solution().findCheapestPrice(4, [[0, 1, 1], [0, 2, 5], [1, 2, 1], [2, 3, 1]], 0, 3, 1) == 6

assert Solution().findCheapestPrice(n=5,
                                    flights=[[0, 2, 100], [2, 4, 100], [0, 4, 300], [0, 1, 10], [1, 3, 10], [3, 4, 20]],
                                    src=0, dst=4, k=2) == 40

assert Solution().findCheapestPrice(n=5,
                                    flights=[[0, 2, 100], [2, 4, 100], [0, 4, 300], [0, 1, 10], [1, 3, 10], [3, 4, 20]],
                                    src=0, dst=4, k=1) == 200

assert Solution().findCheapestPrice(n=5,
                                    flights=[[0, 2, 100], [2, 4, 100], [0, 4, 300], [0, 1, 10], [1, 3, 10], [3, 4, 20]],
                                    src=0, dst=4, k=0) == 300
