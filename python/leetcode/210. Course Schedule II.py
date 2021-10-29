from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = {i: set() for i in range(numCourses)}
        gray = set()
        black = set()
        for pre in prerequisites:
            graph[pre[1]].add(pre[0])

        self.has_cycle = False
        self.ans = []

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
            self.ans.append(cur_node)
            gray.remove(cur_node)
            black.add(cur_node)

        for node in graph:
            dfs(node, graph)

        if self.has_cycle:
            return []
        self.ans.reverse()
        return self.ans


assert Solution().findOrder(numCourses=4, prerequisites=[[1, 0], [2, 0], [3, 1], [3, 2]]) == [0, 2, 1, 3]
print("tests passed")
