from typing import List


class Solution:

    # cpu O(nodes) and ram O
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        self.count_visited = 0

        def dfs(cur_node, visited, rooms):
            match self.count_visited:
                case amount if amount == len(rooms):
                    return
                case _:
                    match visited[cur_node]:
                        case 1:
                            return
                        case _:
                            if visited[cur_node] == 0:
                                self.count_visited += 1
                            visited[cur_node] = 1
                            children = rooms[cur_node]
                            for child in children:
                                dfs(child, visited, rooms)

        dfs(0, [0] * len(rooms), rooms)
        return self.count_visited == len(rooms)


assert not Solution().canVisitAllRooms([[1, 3], [3, 0, 1], [2], [0]])
assert Solution().canVisitAllRooms([[1], [2], [3], []])
print("tests passed")
