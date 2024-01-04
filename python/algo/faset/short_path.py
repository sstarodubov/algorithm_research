from collections import deque

from algo.faset.graph import Graph, Node

graph = Graph()

nodes = [Node(0),
         Node(1),
         Node(2),
         Node(3),
         Node(4),
         Node(5),
         Node(6)
         ]

for n in nodes:
    graph.add_node(n)

graph.add_edge(0, 1)
graph.add_edge(1, 2)
graph.add_edge(0, 2)
graph.add_edge(1, 3)
graph.add_edge(3, 6)
graph.add_edge(2, 4)
graph.add_edge(4, 5)
graph.add_edge(5, 6)


def BFS(s: int, e: int):
    dq = deque()
    dq.append(graph.nodes(s))
    visited = set()
    prev = {}
    while dq:
        cur: Node = dq.popleft()
        if cur.id == e:
            break
        if cur in visited:
            continue

        visited.add(cur)
        for neighbor in cur.neighbors:
            if neighbor not in visited:
                prev[neighbor.id] = cur.id
                dq.append(neighbor)
    short_path = []
    nxt = e
    while nxt in prev:
        short_path.append(prev[nxt])
        nxt = prev[nxt]
    short_path.reverse()
    short_path.append(e)
    return short_path


path = BFS(0, 6)
print(path)

