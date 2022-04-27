from typing import List


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def neighbors(n: int):
            neighbors = []
            for i in range(len(isConnected[n])):
                if i != n and isConnected[n][i] == 1:
                    neighbors.append(i)
            return neighbors

        def dfs(node: int, seen):
            if node in seen:
                return
            seen.add(node)
            ns = neighbors(node)
            for neighbor in ns:
                dfs(neighbor, seen)

        ans = 0
        seen = set()
        for i in range(len(isConnected)):
            if i not in seen:
                dfs(i, seen)
                ans += 1

        return ans


assert 3 == Solution().findCircleNum([[1, 0, 0], [0, 1, 0], [0, 0, 1]])
assert 2 == Solution().findCircleNum([[1, 1, 0], [1, 1, 0], [0, 0, 1]])
