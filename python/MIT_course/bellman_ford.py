from typing import List, Any

# time O(v * e)
def bellman_ford(node_names: List[str], edges: List[List[Any]], src: str, target: str):
    dist = {name: float("inf") for name in node_names}
    dist[src] = 0

    for i in range(len(node_names) - 1):
        for edge in edges:
            cur_node = edge[0]
            neighbor = edge[1]
            weight = edge[2]
            new_dist = dist[cur_node] + weight
            if new_dist < dist[neighbor]:
                dist[neighbor] = new_dist

    for edge in edges:
        cur_node = edge[0]
        neighbor = edge[1]
        weight = edge[2]
        new_dist = dist[cur_node] + weight
        if new_dist < dist[neighbor]:
            print("negative cycle is detected")
            return -1

    return dist[target]


print(
    bellman_ford(["A", "C", "D", "B", "E"],
                 [["A", "C", 6], ["A", "D", 6], ["C", "D", 1], ["D", "C", 2], ["D", "B", 1], ["B", "A", 3],
                  ["E", "B", 4], ["E", "D", 2]],
                 "C", "B"))
