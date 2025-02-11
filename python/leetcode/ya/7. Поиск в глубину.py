import  sys

def read_n(n, type):
   return list(map(type, input().split(" ")))

n,m = map(int, input().split(" "))

edges = []

for _ in range(m):
    edges.append(read_n(2, int))

def build_graph(edges):
    g = {}
    for edge in edges:
        b, e = edge
        bset = g.get(b, set())
        eset = g.get(e, set())
        bset.add(e)
        eset.add(b)
        g[e] = eset
        g[b] = bset
    return g

graph = build_graph(edges)

def dfs(graph, n, compo, visited):
    if n in visited:
        return
    visited.add(n)
    compo.add(n)

    for child in graph[n]:
        dfs(graph, child, compo, visited)

def build_components(graph):
    compo = set()
    visited = set()
    for n in graph:
        if n not in visited:
           dfs(graph, n, compo, visited)
           if 1 in compo:
               l = list(compo)
               l.sort()
               return l
           else:
               compo.clear()

    return []

result = build_components(graph)
print(len(result))
print(" ".join(map(str, result)))