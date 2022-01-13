from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ans = []
        target = len(graph) - 1

        def dfs(cur_node: int = 0, comb: List[int] = []):
            comb.append(cur_node)
            if cur_node == target:
                ans.append(comb[:])
            neighbors = graph[cur_node]
            for neighbor in neighbors:
                dfs(neighbor, comb)
                if comb: comb.pop()

        dfs()
        return ans


assert Solution().allPathsSourceTarget([[1, 2], [3], [3], []]) == [[0,1,3],[0,2,3]]
assert Solution().allPathsSourceTarget([[4, 3, 1], [3, 2, 4], [3], [4], []]) == [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
print("tests passed")
