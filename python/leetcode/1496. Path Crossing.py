class Solution:
    def isPathCrossing(self, path: str) -> bool:
        x, y = 0, 0
        visited = set()
        for p in path:
            key = (x, y)
            visited.add(key)
            match p:
                case "N":
                    y += 1
                case "W":
                    x -= 1
                case "E":
                    x += 1
                case "S":
                    y -= 1
            if (x, y) in visited:
                return True
        return False


assert not Solution().isPathCrossing("NES")
assert Solution().isPathCrossing("NESWW")
