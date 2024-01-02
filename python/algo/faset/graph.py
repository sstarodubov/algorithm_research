from typing import List, Dict, Optional


class Node:
    def __init__(self, id: int):
        self.id = id
        self.neighbors: List[Node] = []

    def __str__(self):
        return f"Node(id={self.id})"


class Graph:
    def __init__(self):
        self._nodes: Dict[int, Node] = {}

    def nodes(self):
        return list(self._nodes.values())

    def add_node(self, node: Node):
        if node.id in self._nodes: raise RuntimeError(f"node with id {node.id} exists")
        self._nodes[node.id] = node

    def add_edge(self, id1: int, id2: int):
        n1 = self._nodes[id1]
        n2 = self._nodes[id2]
        n1.neighbors.append(n2)
        n2.neighbors.append(n1)
