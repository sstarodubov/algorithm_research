import heapq
from typing import List


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = {}
        dist = {}
        for i in range(1, n + 1):
            graph[i] = {}
            dist[i] = float("inf")

        for frm, to, w in times:
            graph[frm][to] = w
        hp = [(0, k)]
        dist[k] = 0

        while hp:
            d, n = heapq.heappop(hp)

            neighbors = graph[n]

            for neighbor in neighbors.keys():
                w = neighbors[neighbor]
                new_dist = dist[n] + w
                if new_dist < dist[neighbor]:
                    dist[neighbor] = new_dist
                    heapq.heappush(hp, (w, neighbor))

        ans = float("-inf")
        for nx in dist:
            if dist[nx] == float("inf"):
                return -1
            ans = max(dist[nx], ans)
        return ans


assert 2 == Solution().networkDelayTime(times=[[2, 1, 1], [2, 3, 1], [3, 4, 1]], n=4, k=2)
