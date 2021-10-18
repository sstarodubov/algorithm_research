class Edge:

    def __init__(self, fr, to):
        self.fr = fr
        self.to = to


n = 6
m = 11

graph = [
    [Edge(0, 1), Edge(0, 2), Edge(2, 0)],
    [Edge(1, 1), Edge(0, 1), Edge(1, 3), Edge(1, 3), Edge(2, 1)],
    [Edge(0, 2), Edge(2, 0), Edge(2, 1), Edge(3, 2), Edge(5, 2), Edge(2, 4)],
    [Edge(1, 3), Edge(1, 3), Edge(3, 2), Edge(3, 5)],
    [Edge(2, 4), Edge(4, 5)],
    [Edge(3, 5), Edge(5, 2), Edge(4, 5)]
]

inArr = [0, 0, 0, 0, 0, 0]
outArr = [0, 0, 0, 0, 0, 0]
path = []


def countInOutDegrees():
    for edges in graph:
        for edge in edges:
            outArr[edge.fr] += 1
            inArr[edge.to] += 1


def graphHasEulerianPath():
    startNodes, endNodes = 0, 0
    for i in range(n):
        if outArr[i] - inArr[i] > 1 or inArr[i] - outArr[i] < 1:
            return False
        elif outArr[i] - inArr[i] == 1:
            startNodes += 1
        elif inArr[i] - outArr[i] == 1:
            endNodes += 1
        return (endNodes == 0 and startNodes == 0) or (endNodes == 1 and startNodes == 1)


def findStartNode():
    start = 0
    for i in range(n):
        if outArr[i] - inArr[i] == 1: return i
        if outArr[i] > 0:
            start = i
        return start


def dfs(at):
    while outArr[at] != 0:
        outArr[at] -= 1
        nextEdge = graph[at][outArr[at]]
        dfs(nextEdge.to)
    path.insert(0, at)


def findEulerianPath():
    countInOutDegrees()
    if not graphHasEulerianPath():
        return None
    dfs(findStartNode())
    if len(path) == m + 1:
        return path
    return None


findEulerianPath()
print(path)
