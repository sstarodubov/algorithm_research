from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # rows
        for row in range(len(board)):
            nums = set()
            for col in range(len(board[0])):
                x = board[row][col]
                if x == ".":
                    continue
                if x in nums:
                    return False
                nums.add(x)
        # col
        for row in range(len(board)):
            nums = set()
            for col in range(len(board[0])):
                y = board[col][row]
                if y == ".":
                    continue
                if y in nums:
                    return False
                nums.add(y)

        # boxes
        def box(xs, xe, ys, ye) -> bool:
            nums = set()
            for row in range(xs, xe + 1):
                for col in range(ys, ye + 1):
                    b = board[col][row]
                    if b == ".":
                        continue
                    if b in nums:
                        return False
                    nums.add(b)
            return True

        arr = [
            box(0, 2, 0, 2), box(3, 5, 0, 2), box(6, 8, 0, 2),
            box(0, 2, 3, 5), box(3, 5, 3, 5), box(6, 8, 3, 5),
            box(0, 2, 6, 8), box(3, 5, 6, 8), box(6, 8, 6, 8)
        ]

        for bo in arr:
            if not bo:
                return False

        return True


assert not Solution().isValidSudoku(
    [[".", ".", ".", ".", "5", ".", ".", "1", "."],
     [".", "4", ".", "3", ".", ".", ".", ".", "."],
     [".", ".", ".", ".", ".", "3", ".", ".", "1"],
     ["8", ".", ".", ".", ".", ".", ".", "2", "."],
     [".", ".", "2", ".", "7", ".", ".", ".", "."],
     [".", "1", "5", ".", ".", ".", ".", ".", "."],
     [".", ".", ".", ".", ".", "2", ".", ".", "."],
     [".", "2", ".", "9", ".", ".", ".", ".", "."],
     [".", ".", "4", ".", ".", ".", ".", ".", "."]

     ])
assert not Solution().isValidSudoku([["8", "3", ".", ".", "7", ".", ".", ".", "."]
                                        , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
                                        , [".", "9", "8", ".", ".", ".", ".", "6", "."]
                                        , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
                                        , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
                                        , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
                                        , [".", "6", ".", ".", ".", ".", "2", "8", "."]
                                        , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
                                        , [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
assert Solution().isValidSudoku([["5", "3", ".", ".", "7", ".", ".", ".", "."]
                                    , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
                                    , [".", "9", "8", ".", ".", ".", ".", "6", "."]
                                    , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
                                    , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
                                    , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
                                    , [".", "6", ".", ".", ".", ".", "2", "8", "."]
                                    , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
                                    , [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
