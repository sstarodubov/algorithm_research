from typing import List


class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 1 and len(matrix[0]) == 1:
            return 1
        graph = {}
        for c in range(len(matrix)):
            for r in range(len(matrix[0])):
                dr = [0, 0, +1, -1]
                dc = [+1, -1, 0, 0]
                for i in range(4):
                    cc = c + dc[i]
                    rr = r + dr[i]

                    if cc < 0 or rr < 0:
                        continue
                    if cc >= len(matrix) or rr >= len(matrix[0]):
                        continue

                    cur_node = (c, r)

                    if cur_node not in graph:
                        graph[cur_node] = []
                    if matrix[c][r] < matrix[cc][rr]:
                        graph[cur_node].append((cc, rr))

        # memo = [[0 for x in range(len(matrix[0]))] for y in range(len(matrix))]
        self.ans = 1

        def dfs(cur_column, cur_row, length, visited):
            node = (cur_column, cur_row)
            if node in visited:

                return
            visited.add(node)
            new_len = length + 1
            self.ans = max(self.ans, new_len)
            children = graph[node]
            for child in children:
                child_col, child_row = child
                dfs(child_col, child_row, new_len, visited)
            if node in visited:
                visited.remove(node)


        for c in range(len(matrix)):
            for r in range(len(matrix[0])):
                dfs(c, r, 0, set())

        return self.ans


assert Solution().longestIncreasingPath([[9, 9, 4], [6, 6, 8], [2, 1, 1]]) == 4
assert Solution().longestIncreasingPath([[3, 4, 5], [3, 2, 6], [2, 2, 1]]) == 4
assert Solution().longestIncreasingPath([[1]]) == 1
print("tests passed")
