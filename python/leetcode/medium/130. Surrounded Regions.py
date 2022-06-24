from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        disjoint_set = {}

        def union(n1, n2):
            if disjoint_set[n1] == disjoint_set[n2]:
                return

            if len(disjoint_set[n1]) < len(disjoint_set[n2]):
                for k in disjoint_set[n1]:
                    disjoint_set[n2].add(k)
                    disjoint_set[k] = disjoint_set[n2]
            else:
                for k in disjoint_set[n2]:
                    disjoint_set[n1].add(k)
                    disjoint_set[k] = disjoint_set[n1]

        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] == "O":
                    if row == 0 or col == 0 or row == len(board) - 1 or col == len(board[0]) - 1:
                        disjoint_set[(row, col)] = {(row, col), -1}
                    else:
                        disjoint_set[(row, col)] = {(row, col)}

        for row in range(len(board)):
            for col in range(len(board[0])):
                cur = (row, col)
                if board[row][col] == "O":
                    if row + 1 < len(board) and board[row + 1][col] == "O":
                        union(cur, (row + 1, col))
                    if col + 1 < len(board[0]) and board[row][col + 1] == "O":
                        union(cur, (row, col + 1))

        for k in disjoint_set.keys():
            if -1 not in disjoint_set[k]:
                for row, col in disjoint_set[k]:
                    board[row][col] = "X"



Solution().solve([["O", "X", "O", "O", "O", "X"], ["O", "O", "X", "X", "X", "O"], ["X", "X", "X", "X", "X", "O"],
                  ["O", "O", "O", "O", "X", "X"], ["X", "X", "O", "O", "X", "O"], ["O", "O", "X", "X", "X", "X"]])
Solution().solve(
    [["O", "X", "X", "O", "X"], ["X", "O", "O", "X", "O"], ["X", "O", "X", "O", "X"], ["O", "X", "O", "O", "O"],
     ["X", "X", "O", "X", "O"]])
Solution().solve([["O", "O", "O"], ["O", "O", "O"], ["O", "O", "O"]]) == [["O", "O", "O"], ["O", "O", "O"],
                                                                          ["O", "O", "O"]]
Solution().solve(board=[["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"]])
