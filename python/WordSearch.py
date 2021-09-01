from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        used = [[False for _ in col] for col in board]

        def found(y, x, idx: int) -> bool:
            # found solution
            if idx == len(word):
                return True
            # validation
            if y < 0 or x < 0:
                return False
            if y >= len(board) or x >= len(board[0]):
                return False

            if word[idx] != board[y][x]:
                return False
            if used[y][x]:
                return False
            # apply
            used[y][x] = True
            if found(y - 1, x, idx + 1) or \
                    found(y + 1, x, idx + 1) or \
                    found(y, x + 1, idx + 1) or \
                    found(y, x - 1, idx + 1):
                return True
            used[y][x] = False
            return False

        for y in range(len(board)):
            for x in range(len(board[0])):
                if word[0] == board[y][x] and found(y, x, 0):
                    return True
        return False


s = Solution()

assert s.exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "SEE"), "c"
assert s.exist([["H", "E", "L", "L"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ELL"), "c"
assert s.exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCCED"), "a"
assert not s.exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCB"), "b"
print("tests passed")
