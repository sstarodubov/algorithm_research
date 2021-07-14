"""
You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters
you can make using the letters printed on those tiles.
"""


class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        tree: set[str] = set()
        self.permutations_helper_finder(0, list(tiles), tree)
        return len(tree)

    def permutations_helper_finder(self, i, array, tree: set[str]):
        if i >= len(array): return
        for j in range(0, len(array)):
            word: str = "".join(array)[j:i + 1]
            if word: tree.add(word)
            self.swap(array, i, j)
            self.permutations_helper_finder(i + 1, array, tree)
            self.swap(array, j, i)

    def swap(self, arr, i, y):
        arr[i], arr[y] = arr[y], arr[i]


s = Solution()
assert 8 == s.numTilePossibilities("AAB"), "1"
assert 1 == s.numTilePossibilities("S"), "2"
assert 188 == s.numTilePossibilities("AAABBC"), "3"

print("tests passed")