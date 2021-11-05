from typing import List


class Solution:

    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        memo = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]

        def dfs(c, r) -> int:
            if memo[c][r]:
                return memo[c][r]
            dr = [+1, -1, 0, 0]
            dc = [0, 0, +1, -1]
            tmp = [0] * 4
            for i in range(4):
                cc = c + dc[i]
                rr = r + dr[i]
                if cc >= len(matrix) or rr >= len(matrix[0]):
                    continue
                if cc < 0 or rr < 0:
                    continue
                if matrix[cc][rr] > matrix[c][r]:
                    tmp[i] = dfs(cc, rr)
            maximum = max(tmp)
            memo[c][r] = maximum + 1
            return memo[c][r]

        ans = 0
        for c in range(len(matrix)):
            for r in range(len(matrix[0])):
                ans = max(ans, dfs(c, r))
        return ans

    # cpu O(n ^ 2) and ram O(n)
    # def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
    #     if len(matrix) == 1 and len(matrix[0]) == 1:
    #         return 1
    #     graph = {}
    #     for c in range(len(matrix)):
    #         for r in range(len(matrix[0])):
    #             dr = [0, 0, +1, -1]
    #             dc = [+1, -1, 0, 0]
    #             for i in range(4):
    #                 cc = c + dc[i]
    #                 rr = r + dr[i]
    #
    #                 if cc < 0 or rr < 0:
    #                     continue
    #                 if cc >= len(matrix) or rr >= len(matrix[0]):
    #                     continue
    #
    #                 cur_node = (c, r)
    #
    #                 if cur_node not in graph:
    #                     graph[cur_node] = []
    #                 if matrix[c][r] < matrix[cc][rr]:
    #                     graph[cur_node].append((cc, rr))
    #
    #     memo = [[0 for x in range(len(matrix[0]))] for y in range(len(matrix))]
    #
    #     def dfs(cur_column, cur_row, visited) -> int:
    #         node = (cur_column, cur_row)
    #         if memo[cur_column][cur_row]:
    #             return memo[cur_column][cur_row]
    #
    #         visited.add(node)
    #         children = graph[node]
    #         size = 0
    #         if not children:
    #             memo[cur_column][cur_row] = max(memo[cur_column][cur_row], size + 1)
    #             return memo[cur_column][cur_row]
    #         for child in children:
    #             child_col, child_row = child
    #             size = max(dfs(child_col, child_row, visited), size)
    #         visited.remove(node)
    #         memo[cur_column][cur_row] = max(memo[cur_column][cur_row], size + 1)
    #         return memo[cur_column][cur_row]
    #
    #     ans = 1
    #     for c in range(len(matrix)):
    #         for r in range(len(matrix[0])):
    #             ans = max(ans, dfs(c, r, set()))
    #
    #     return ans


assert Solution().longestIncreasingPath([[3, 4, 5], [3, 2, 6]]) == 4
assert Solution().longestIncreasingPath([[7, 7, 5], [2, 4, 6], [8, 2, 0]]) == 4
assert Solution().longestIncreasingPath([[3, 4, 5], [3, 2, 6], [2, 2, 1]]) == 4
assert Solution().longestIncreasingPath([[9, 9, 4], [6, 6, 8], [2, 1, 1]]) == 4
assert Solution().longestIncreasingPath([[1]]) == 1
print("tests passed")
