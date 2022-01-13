import heapq
from typing import Dict

graph = {
    "0": {"1": 5, "2": 1},
    "1": {"3": 3, "4": 20, "2": 2},
    "2": {"1": 3, "4": 12},
    "3": {"2": 3, "4": 2, "5": 6},
    "4": {"5": 1},
    "5": {}
}


def dijkstra(start: str, end: str, g: Dict = graph) -> int:
    dist = {k: float("inf") for k in g.keys()}
    parents = {k: None for k in g.keys()}

    dist[start] = 0
    pq = [(0, start)]
    heapq.heapify(pq)

    while pq:
        cur_dist, cur_node_name = heapq.heappop(pq)

        neighbors = g.get(cur_node_name)

        for neighbor in neighbors.keys():
            weight = neighbors.get(neighbor)
            new_dist = cur_dist + weight
            if new_dist < dist[neighbor]:
                dist[neighbor] = new_dist
                heapq.heappush(pq, (weight, neighbor))
                parents[neighbor] = cur_node_name

    return dist[end]


assert dijkstra("0", "3") == 7
assert dijkstra("3", "0") == float("inf")
assert dijkstra("0", "1") == 4
assert dijkstra("2", "3") == 6

print("tests passed")
