


graph = {
    2: [1, 3, 4],
    3: [1,4],
}

visited = {}
def topological_sort(graph, vertex,  arr = []):
    if not vertex:
        return
    if graph.get(vertex) is None and visited.get(vertex) is None:
        arr.append(vertex)
        visited[vertex] = True

    else:
        children = graph.get(vertex)
        if children is not None:
            for child in children:
                topological_sort(graph, child, arr)

        if visited.get(vertex) is None:
            arr.append(vertex)

    return arr

print(topological_sort(graph, 2, []))