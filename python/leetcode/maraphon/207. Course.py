from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        black, gray = set(), set()

        graph = {}
        for i in range(numCourses):
            graph[i] = set()

        for fr, to in prerequisites:
            graph[fr].add(to)
        self.result = True

        def dfs(node: int):
            if node in black:
                return
            if node in gray:
                self.result = False
                return

            gray.add(node)
            for child in graph[node]:
                dfs(child)

            black.add(node)

        for i in list(graph.keys()):
            if i not in gray and i not in black:
                dfs(i)

        return self.result


assert not Solution().canFinish(2, [[1, 0], [0, 1]])
assert Solution().canFinish(2, [[0, 1]])
