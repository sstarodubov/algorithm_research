from typing import List


class Solution:
    # cpu O(vertex + edges) and ram O(vertex)
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {i: set() for i in range(numCourses)}
        white = set()
        gray = set()
        black = set()
        for pre in prerequisites:
            graph[pre[1]].add(pre[0])
            white.add(pre[1])
            white.add(pre[0])
        self.has_cycle = False

        def dfs(cur_node, graph):
            if self.has_cycle:
                return
            if cur_node in black:
                return
            if cur_node in gray:
                self.has_cycle = True
                return
            gray.add(cur_node)
            children = graph[cur_node]
            for child in children:
                dfs(child, graph)
            gray.remove(cur_node)
            black.add(cur_node)

        for node in graph:
            dfs(node, graph)

        return True if not self.has_cycle else False


assert Solution().canFinish(7, [[2, 5], [3, 5], [1, 2], [1, 3], [1, 6], [3, 6], [3, 4]])
assert Solution().canFinish(numCourses=2, prerequisites=[[1, 0]])
assert not Solution().canFinish(numCourses=2, prerequisites=[[1, 0], [0, 1]])

print("test passed")
