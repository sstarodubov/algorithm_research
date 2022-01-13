import heapq
import math
from collections import defaultdict
from typing import List, Dict


class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        graph = defaultdict(list)
        for u, v, time in roads:
            graph[u].append([v, time])
            graph[v].append([u, time])

        def dijkstra(src):
            dist = [math.inf] * n
            ways = [0] * n
            heap = [(0, src)]  # dist, src
            dist[src] = 0
            ways[src] = 1
            while heap:
                d, u = heapq.heappop(heap)
                for v, time in graph[u]:
                    if dist[v] > d + time:
                        dist[v] = d + time
                        ways[v] = ways[u]
                        heapq.heappush(heap, (dist[v], v))
                    elif dist[v] == d + time:
                        ways[v] = (ways[v] + ways[u]) % 1_000_000_007
            return ways[n - 1]

        return dijkstra(0)


assert Solution().countPaths(7, [[0, 6, 7], [0, 1, 2], [1, 2, 3], [1, 3, 3], [6, 3, 3], [3, 5, 1], [6, 5, 1], [2, 5, 1],
                                 [0, 4, 5], [4, 6, 2]]) == 4

assert Solution().countPaths(n=2, roads=[[1, 0, 10]]) == 1
print("tests passed")
