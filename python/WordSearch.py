from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def startswith(xs, ys):
            if len(ys) > len(xs):
                return False
            for i in range(len(ys)):
                if ys[i] != xs[i]:
                    return False
            return True

        used = [[False for _ in col] for col in board]
        word_list = list(word)

        def found(cur_word: [str], cell: (int, int)) -> bool:
            # found solution
            if word_list == cur_word:
                return True
            # validation
            y, x = cell
            if y < 0 or x < 0:
                return False
            if y >= len(board) or x >= len(board[0]):
                return False

            if ((startswith(word_list, cur_word)) and not used[y][x]) or cur_word == []:
                # apply
                cur_word.append(board[y][x])
                used[y][x] = True
                if found(cur_word, (y - 1, x)):
                    return True
                if found(cur_word, (y + 1, x)):
                    return True
                if found(cur_word, (y, x + 1)):
                    return True
                if found(cur_word, (y, x - 1)):
                    return True
                cur_word.pop()
                used[y][x] = False
                if not cur_word:
                    y += 1
                    if y >= len(board):
                        y = 0
                        x += 1
                    return found(cur_word, (y, x))
            return False

        ans = found([], (0, 0))
        return ans


s = Solution()

assert s.exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "SEE"), "c"
assert s.exist([["H", "E", "L", "L"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ELL"), "c"
assert s.exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCCED"), "a"
assert not s.exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCB"), "b"
print("tests passed")
