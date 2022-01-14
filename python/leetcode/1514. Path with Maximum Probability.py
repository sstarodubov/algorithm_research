import heapq
from typing import List


class Pair:
    def __init__(self, dist, node):
        self.dist = dist
        self.node = node

    def __lt__(self, other): return self.dist > other.dist

    def __eq__(self, other): return self.dist == other.dist


class Solution:

    # time O( n log n) and space O(n)
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        graph = {k: {} for k in range(n)}
        for i in range(len(edges)):
            graph[edges[i][0]][edges[i][1]] = succProb[i]
            graph[edges[i][1]][edges[i][0]] = succProb[i]

        def dijkstra(src: int, target: int):
            dist = [0] * n
            visited = set()
            heap = [Pair(0, src)]
            dist[src] = 1

            while heap:
                pair = heapq.heappop(heap)
                cur_node = pair.node
                cur_dist = pair.dist

                if cur_node in visited:
                    continue

                visited.add(cur_node)

                for neighbor in graph[cur_node].keys():
                    new_dist = dist[cur_node] * graph[cur_node][neighbor]
                    if new_dist > dist[neighbor]:
                        dist[neighbor] = new_dist
                        heapq.heappush(heap, Pair(new_dist, neighbor))
            return dist[target]

        return dijkstra(start, end)


assert Solution().maxProbability(n=3, edges=[[0, 1], [1, 2], [0, 2]], succProb=[0.5, 0.5, 0.2], start=0, end=2) == 0.25
assert Solution().maxProbability(n=3, edges=[[0, 1], [1, 2], [0, 2]], succProb=[0.5, 0.5, 0.3], start=0, end=2) == 0.3
assert Solution().maxProbability(n=3, edges=[[0, 1]], succProb=[0.5], start=0, end=2) == 0
