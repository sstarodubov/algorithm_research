class Edge:
    def __init__(self, fr: int, to: int, w: int):
        self.fr = fr
        self.to = to
        self.w = w


def bellman_ford(edges: [Edge], V: int, start: int, end: int):
    dist = [float("inf")] * V
    dist[start] = 0
    for i in range(V - 1):
        for edge in edges:
            if dist[edge.fr] + edge.w < dist[edge.to]:
                dist[edge.to] = dist[edge.fr] + edge.w

    return dist[end]


graph = [Edge(0, 1, 2), Edge(3, 1, 4), Edge(1, 2, 1),
         Edge(2, 4, 1), Edge(3, 4, 5), Edge(0, 3, 1)]

print(bellman_ford(graph, 5, 0, 4))
