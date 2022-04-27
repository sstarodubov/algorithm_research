from collections import defaultdict
from typing import List


class Solution:

    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:

        def add_edge(graph, edge):
            frm, to = edge
            graph[frm].add(to)
            graph[to].add(frm)

        def remove_edge(graph, edge):
            frm, to = edge
            graph[frm].remove(to)
            graph[to].remove(frm)

        def dfs(graph, node, seen):
            if node in seen:
                return

            seen.add(node)
            children = graph[node]

            for child in children:
                dfs(graph, child, seen)

        graph = defaultdict(lambda: set())

        for edge in edges:
            add_edge(graph, edge)

        for edge in reversed(edges):
            remove_edge(graph, edge)
            seen = set()
            group = 0
            for node in graph.keys():
                if node not in seen:
                    dfs(graph, node, seen)
                    group += 1

            if group == 1:
                return edge

            add_edge(graph, edge)

        return [-1, -1]


assert [2, 3] == Solution().findRedundantConnection([[1, 2], [1, 3], [2, 3]])
assert [1, 4] == Solution().findRedundantConnection([[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]])
