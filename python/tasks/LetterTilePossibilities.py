"""
You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters
you can make using the letters printed on those tiles.
"""
"""
  def numTilePossibilities(self, tiles: str) -> int:
        res = {}

        def dfs(prefix, _tiles):
            if prefix in res:
                return
            res[prefix] = True
            for i, t in enumerate(_tiles):
                newPfx = prefix + t
                a = _tiles[:i]
                b = _tiles[i + 1:]
                dfs(newPfx, a + b)

        dfs('', tiles)
        return len(res.keys()) - 1
"""


class Solution:

    def numTilePossibilities(self, tiles: str) -> int:
        res = {}

        def helper(prefix, _tiles):
            if prefix in res:
                return
            res[prefix] = True
            for i, t in enumerate(_tiles):
                newPfx = prefix + t
                a = _tiles[:i]
                b = _tiles[i + 1:]
                helper(newPfx, a + b)

        helper('', tiles)
        return len(res.keys()) - 1


s = Solution()
assert 8 == s.numTilePossibilities("ABC"), "1"
assert 1 == s.numTilePossibilities("S"), "2"
assert 188 == s.numTilePossibilities("AAABBC"), "3"

print("tests passed")
