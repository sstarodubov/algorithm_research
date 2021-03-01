graph = [[1, 0, 0, 1, 0], [1, 0, 1, 0, 0], [0, 0, 1, 0, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 0]]
visited = [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]


#
# 1, 0, 0, 1, 0
# 1, 0, 1, 0, 0
# 0, 0, 1, 0, 1
# 1, 0, 1, 0, 1
# 1, 0, 1, 1, 0
#
# find rivers length
#
# rives are:
#  1
#  1
#  or
#  1
#  1
#  1
#  1 1


class Lenght:
    val: int = 0

    def increment(self):
        self.val += 1


def find_river_helper(x: int, y: int, length: Lenght):
    if x < 0 or y < 0: return length
    if x >= len(graph) or y >= len(graph[0]):
        return length
    if graph[x][y] == 1 and visited[x][y] == 0:
        visited[x][y] = 1
        length.increment()
        find_river_helper(x + 1, y, length)
        find_river_helper(x - 1, y, length)
        find_river_helper(x, y - 1, length)
        find_river_helper(x, y + 1, length)

    return length


# Space O(n) and Time O(w * h) w - width and height of graph
def find_rivers():
    result = []
    for x in range(len(graph)):
        for y in range(len(graph[x])):
            if graph[x][y] == 0:
                visited[x][y] = 1
            else:
                river_length = find_river_helper(x, y, Lenght())
                if river_length.val != 0:
                    result.append(river_length.val)
    return result
