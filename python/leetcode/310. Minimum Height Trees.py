from typing import List


class Solution:


    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        gr = {i: set() for i in range(n)}
        for edge in edges:
            gr[edge[0]].add(edge[1])
            gr[edge[1]].add(edge[0])
        removed = set()
        remaining_leaves = list(gr.keys())
        saved = []
        while len(gr):
            len_to_remove = float("inf")
            for l in remaining_leaves:
                len_to_remove = min(len(gr[l]), len_to_remove)
            removed.clear()
            for cur_node in remaining_leaves:
                if len_to_remove == len(gr[cur_node]):
                    removed.add(cur_node)
                    del gr[cur_node]
                else:
                    saved.append(cur_node)

            for rem_node in removed:
                for cur_node in gr:
                    if rem_node in gr[cur_node]:
                        gr[cur_node].remove(rem_node)

            remaining_leaves = saved
            saved = []
            len_to_remove += 1
        return list(removed)


assert Solution().findMinHeightTrees(n=6, edges=[[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]) == [3, 4]
print("tests passed")
