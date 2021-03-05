# Дан граф
#         _____A__
#        /     \   \
#     __B___    C   D
#    /      \     /   \
#   E       F    G     H
#          / \   \
#         I   J   K
# нужно пройти по всем элементам его вершин
graph = {'A': ['B', 'C', "D"],
         'B': ['E', 'F'],
         'C': [],
         "E": [],
         "F": ["I", "J"],
         "I": [],
         "J": [],
         'D': ["G", "H"],
         'H': [],
         'G': ["K"],
         "K": []}

# Time = O (Vertexes + Edges) ; Space (Vertexes)
def depth_first_search(graph: {}, vertex: str, arr: [str] = []):
    if not vertex:
        return
    arr.append(vertex)
    children = graph[vertex]
    for child in children:
        depth_first_search(graph, child, arr)
    return arr


