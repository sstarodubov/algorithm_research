from typing import Dict

graph = {
    "a": ["c"],
    "b": ["c"],
    "c": ["f", "g", "h"],
    "f": ["y"],
    "g": ["x"],
    "h": [],
    "y": ["z"],
    "z": [],
    "x": [],

}

topolSorted = []


def topSort(graph, visited, ans):
    for node in graph:
        if node not in visited:
            dfs(graph, visited, node, ans)
        ans.append(node)


def dfs(graph: Dict, visited: Dict, node: str, ans):
    visited[node] = True
    children = graph[node]
    for child in children:
        if child not in visited:
            visited[child] = True
            dfs(graph, visited, child, ans)


topSort(graph, {}, topolSorted)

print((topolSorted))
