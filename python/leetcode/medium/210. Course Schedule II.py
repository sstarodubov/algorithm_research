from typing import List, Set



class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        black, gray, self.cycle, seen, graph = [], set(), False, set(), {}

        for i in range(numCourses):
            graph[i] = set()

        for frm, to in prerequisites:
            graph[frm].add(to)

        def dfs(node: int):
            if node in gray:
                self.cycle = True
                return
            if node in seen:
                return
            gray.add(node)
            seen.add(node)
            children = graph[node]

            for child in children:
                dfs(child)

            gray.remove(node)
            black.append(node)

        for xn in range(numCourses):
            dfs(xn)

        if self.cycle:
            return []

        return black


assert [] == Solution().findOrder(2, [[0, 1], [1, 0]])
assert [0, 1, 2, 3] == Solution().findOrder(numCourses=4, prerequisites=[[1, 0], [2, 0], [3, 1], [3, 2]])
