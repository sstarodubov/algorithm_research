from collections import deque
from typing import List, Set, Dict


class NodePath:

    def __init__(self, val):
        self.val = val
        self.ds = set()

    def __eq__(self, other):
        return self.val == other.val

    def __str__(self):
        return f"Node({self.val})"

    def __hash__(self):
        return hash(self.val)


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        for i in range(len(edges) - 1, -1, -1):
            if not self.helper(edges, i):
                return edges[i]

    def helper(self, edges: List[List[int]], idx) -> bool:
        def make_set(ns: Dict[int, NodePath]):
            for n in list(ns.values()):
                n.ds.add(n)

        def union(np1: NodePath, np2: NodePath):
            for n in np1.ds:
                n.ds = np2.ds
                np2.ds.add(n)

        def in_same_ds(np: NodePath, np2: NodePath) -> bool:
            return np2 in np.ds and np in np2.ds

        nodes = {}

        for frm, to in edges:
            nodes[frm] = NodePath(frm)
            nodes[to] = NodePath(to)

        make_set(nodes)

        for i in range(len(edges) - 1, -1, -1):
            if i == idx:
                continue
            frm = edges[i][0]
            to = edges[i][1]
            if in_same_ds(nodes[frm], nodes[to]):
                return True
            union(nodes[frm], nodes[to])
        return False


assert [1, 4] == Solution().findRedundantConnection([[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]])
assert [2, 5] == Solution().findRedundantConnection([[3, 4], [1, 2], [2, 4], [3, 5], [2, 5]])
assert [2, 3] == Solution().findRedundantConnection([[1, 2], [1, 3], [2, 3]])
