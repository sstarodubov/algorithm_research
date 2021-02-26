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
         "F": ["I", "J", "G"],
         "I": [],
         "J": [],
         'D': ["G", "H"],
         'H': [],
         'G': ["K", "F"],
         "K": []}

visited ={'A':False,
         'B': False,
         'C': False,
         "E": False,
         "F": False,
         "I": False,
         "J": False,
         'D': False,
         'H': False,
         'G': False,
         "K": False
          }

def breadth_first_search(graph: {}, vertex: str):
    queue:list = [vertex]
    visited[vertex] = True
    result = []
    while len(queue) != 0:
        vertex = queue.pop(0)
        result.append(vertex)
        children = graph[vertex]
        for child in children:
            if not visited[child]:
                queue.append(child)
                visited[child] = True

    return result

print(breadth_first_search(graph, "A"))