from typing import List

"""
public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}
"""


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
            return False

        for y in range(len(board)):
            for x in range(len(board[0])):
                if word[0] == board[y][x] and found([], (y, x)):
                    return True
        return False


s = Solution()

assert s.exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "SEE"), "c"
assert s.exist([["H", "E", "L", "L"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ELL"), "c"
assert s.exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCCED"), "a"
assert not s.exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word="ABCB"), "b"
print("tests passed")
