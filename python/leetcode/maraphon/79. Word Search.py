from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.ans = False
        v = [[0 for x in y] for y in board]

        def dfs(row, col, ix):
            if self.ans:
                return
            if ix >= len(word):
                self.ans = True
                return

            if row >= len(board) or row < 0:
                return
            if col >= len(board[0]) or col < 0:
                return
            if v[row][col] == 1:
                return
            if word[ix] != board[row][col]:
                return
            v[row][col] = 1
            dfs(row + 1, col, ix + 1)
            dfs(row - 1, col, ix + 1)
            dfs(row, col + 1, ix + 1)
            dfs(row, col - 1, ix + 1)
            v[row][col] = 0

        for row in range(len(board)):
            for col in range(len(board[0])):
                dfs(row, col, 0)

        return self.ans


assert not Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCB")
assert Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="SEE")
assert Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCCED")
