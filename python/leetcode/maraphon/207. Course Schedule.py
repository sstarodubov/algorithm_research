from collections import defaultdict
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        self.ans = True
        graph = {}
        for n in range(numCourses):
            graph[n] = []
        grey = set()
        black = set()
        for fr, to in prerequisites:
            graph[fr].append(to)

        def dfs(n) :
            if not self.ans or n in black:
                return
            if n in grey:
                self.ans = False
                return
            grey.add(n)

            for ch in graph[n]:
                dfs(ch)

            grey.remove(n)
            black.add(n)


        for n in range(numCourses):
            dfs(n)

        return self.ans


assert not Solution().canFinish(numCourses=3, prerequisites=[[1, 0], [1, 2], [0, 1]])
assert not Solution().canFinish(numCourses=2, prerequisites=[[1, 0], [0, 1]])
assert Solution().canFinish(numCourses=2, prerequisites=[[1, 0]])
