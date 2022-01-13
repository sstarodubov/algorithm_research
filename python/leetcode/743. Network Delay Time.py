import heapq
import math
from collections import defaultdict
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = {i: {} for i in range(1, n + 1)}
        for time in times:
            frm, to, w = time
            graph[frm][to] = w

        dist = defaultdict(lambda: float("inf"))
        visited = set()

        def dijkstra(src: int) -> int:
            heap = [(0, src)]
            dist[src] = 0
            while heap:
                cur_dist, cur_node = heapq.heappop(heap)
                if cur_node in visited: continue

                visited.add(cur_node)

                if cur_dist > dist[cur_node]: continue

                neighbors = graph[cur_node]

                for neighbor in neighbors.keys():
                    if neighbor in visited: continue

                    new_dist = dist[cur_node] + graph[cur_node][neighbor]
                    if new_dist < dist[neighbor]:
                        dist[neighbor] = new_dist
                        heapq.heappush(heap, (new_dist, neighbor))

            if len(visited) != len(list(graph.keys())):
                return -1
            return max(list(dist.values()))

        return dijkstra(k)


assert Solution().networkDelayTime([[1, 2, 1], [2, 3, 7], [1, 3, 4], [2, 1, 2]], 4, 1) == -1
assert Solution().networkDelayTime(times=[[2, 1, 1], [2, 3, 1], [3, 4, 1]], n=4, k=2) == 2
