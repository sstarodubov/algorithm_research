from algo.faset.graph import Graph

graph = {
    "A": ["D"],
    "E": ["A", "D", "F"],
    "C": ["A", "B"],
    "D": ["H", "G"],
    "B": ["D"],
    "H": ["I", "J"],
    "G": ["I"],
    "I": ["L"],
    "F": ["K", "J"],
    "J": ["M", "L"],
    "K": ["J"],
    "L": [],
    "M": []
}
nodes = list(graph.keys())
result = []
visited = set()


def dfs(node, arr):
    if not node:
        return
    if node in visited:
        return
    visited.add(node)
    neighborhood = graph[node]
    for neighbor in neighborhood:
        dfs(neighbor, result)
    arr.append(node)


def topsort():
    for n in nodes:
        if n not in visited:
            dfs(n, result)
    result.reverse()


topsort()
print(result)
