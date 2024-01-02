from typing import Optional, Set

from algo.faset.graph import Graph, Node


class ColoredNode(Node):

    def __init__(self, id: int):
        super().__init__(id)
        self.color = None

    def set_color(self, color: int):
        self.color = color

    def __str__(self):
        return f"Node(id={self.id}, color={self.color})"


gr = Graph()

n1 = ColoredNode(1)
n2 = ColoredNode(2)
n3 = ColoredNode(3)
n4 = ColoredNode(4)
n5 = ColoredNode(5)
n6 = ColoredNode(6)
n7 = ColoredNode(7)
n8 = ColoredNode(8)

gr.add_node(n1)
gr.add_node(n2)
gr.add_node(n3)
gr.add_node(n4)
gr.add_node(n5)
gr.add_node(n6)
gr.add_node(n7)
gr.add_node(n8)

gr.add_edge(1, 2)
gr.add_edge(1, 3)
gr.add_edge(2, 3)

gr.add_edge(5, 6)
gr.add_edge(6, 7)
gr.add_edge(8, 7)
gr.add_edge(8, 5)


def DFS(at: Optional[ColoredNode], visited: Set[Node], color_id: int):
    if not at:
        return

    if at in visited:
        return
    visited.add(at)

    at.set_color(color_id)

    for neighbor in at.neighbors:
        DFS(neighbor, visited, color_id)


def color_graph(graph: Graph):
    visit = set()
    color_id = 0
    for n in graph.nodes():
        if n not in visit:
            DFS(n, visit, color_id)
            color_id += 1


color_graph(gr)
