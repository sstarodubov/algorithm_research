from typing import List, Set, Dict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True
        graphs = {}
        for course in range(numCourses):
            graphs[course] = set()

        for frm, to in prerequisites:
            graphs[frm].add(to)

        self.cycle = False

        def dfs(g: Dict[int, Set[int]], node: int, visit: Set[int], gray: Set[int]):
            if node in gray:
                self.cycle = True
            if node in visit:
                return
            visit.add(node)
            gray.add(node)
            children = g[node]
            for child in children:
                dfs(g, child, visit, gray)

            gray.remove(node)

        visit = set()
        gray = set()
        for i in range(numCourses):
            dfs(graphs, i, visit, gray)

        return len(visit) == numCourses and not self.cycle


assert not Solution().canFinish(2, [[1, 0], [0, 1]])
assert Solution().canFinish(2, [[1, 0]])
