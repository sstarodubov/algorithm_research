


class Solution:
    def exist(self, board, word):
        def dfs(i, j, cur):
            if len(cur) == 0:
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or cur[0] != board[i][j]:
                return False
            tmp = board[i][j]
            board[i][j] = "$"
            ans = dfs(i + 1, j, cur[1:]) or dfs(i - 1, j, cur[1:]) or dfs(i, j + 1, cur[1:]) or dfs(i, j - 1,
                                                                                                    cur[1:])
            board[i][j] = tmp
            return ans

        if not board: return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, word): return True
        return False


assert Solution().exist([["a", "b"], ["c", "d"]], "cdba")
assert Solution().exist([["a", "b"]], "ba")
assert not Solution().exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ABCB")
assert Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCCED")
assert Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="SEE")
assert not Solution().exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCB")
