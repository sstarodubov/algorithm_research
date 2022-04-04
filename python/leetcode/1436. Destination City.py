from typing import List


class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        graph = {}
        for frm, to in paths:
            graph[frm] = to

        cur = paths[0][0]
        prv = None
        while cur:
            prv = cur
            cur = graph.get(cur)
        return prv


assert Solution().destCity([["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]]) == "Sao Paulo"
