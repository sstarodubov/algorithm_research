import heapq
from typing import List


class Edge:
    def __init__(self, frm, to, weight):
        self.frm = frm
        self.to = to
        self.weight = weight

    def __str__(self):
        return f"Edge:(from={self.frm},to={self.to},weight={self.weight})"


class Path:
    def __init__(self, to, distance):
        self.to = to
        self.distance = distance

    def __cmp__(self, other):
        if self.distance < other.distance:
            return -1
        if self.distance > other.distance:
            return 1
        return 0

    def __lt__(self, other):
        return self.distance < other.distance

    def __gt__(self, other):
        return self.distance > other.distance

    def __str__(self):
        return f"Path(to=${self.to},distance=${self.distance}"


class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        if len(grid) == 1 and len(grid[0]) == 1:
            return 0
        graph = {}
        for c in range(len(grid)):
            for r in range(len(grid[0])):
                dr = [0, 0, -1, +1]
                dc = [-1, +1, 0, 0]
                for i in range(4):
                    rr = r + dr[i]
                    cc = c + dc[i]
                    if rr >= len(grid[0]) or cc >= len(grid):
                        continue
                    if rr < 0 or cc < 0:
                        continue
                    cur_node = (c, r)
                    if cur_node not in graph:
                        graph[cur_node] = {}
                    neigb = (cc, rr)
                    cur_node = (c, r)
                    graph[cur_node][neigb] = Edge(cur_node, neigb, 1)

                cur_node = (c, r)
                arrow = grid[c][r]
                if arrow == 1 and r + 1 < len(grid[0]):
                    edge = graph[cur_node].get((c, r + 1))
                    if edge:
                        edge.weight = 0
                elif arrow == 2 and r - 1 >= 0:
                    edge = graph[cur_node].get((c, r - 1))
                    if edge:
                        edge.weight = 0
                elif arrow == 3 and c + 1 < len(grid):
                    edge = graph[cur_node].get((c + 1, r))
                    if edge:
                        edge.weight = 0
                elif arrow == 4 and c - 1 >= 0:
                    edge = graph[cur_node].get((c - 1, r))
                    if edge:
                        edge.weight = 0

        pq = []
        heapq.heapify(pq)
        visited = {key: False for key in graph.keys()}
        dist = {key: float("inf") for key in graph.keys()}
        start, end = (0, 0), (len(grid) - 1, len(grid[0]) - 1)
        dist[start] = 0
        heapq.heappush(pq, Path(start, 0))
        while pq:
            cur_path: Path = heapq.heappop(pq)
            node_id = cur_path.to
            visited[node_id] = True
            if dist[node_id] < cur_path.distance:
                continue
            for key in graph[node_id].keys():
                edge = graph[node_id][key]
                if visited[edge.to]:
                    continue
                new_dist = dist[edge.frm] + edge.weight
                if new_dist < dist[edge.to]:
                    dist[edge.to] = new_dist
                    heapq.heappush(pq, Path(edge.to, dist[edge.to]))
            if node_id == end:
                return dist[end]
        return dist[end]


assert Solution().minCost([[1, 1, 3], [3, 2, 2], [1, 1, 4]]) == 0
assert Solution().minCost([[1, 1, 1, 1], [2, 2, 2, 2], [1, 1, 1, 1], [2, 2, 2, 2]]) == 3
assert Solution().minCost([[2, 2, 2], [2, 2, 2]]) == 3
assert Solution().minCost([[4]]) == 0
print("tests passed")
