graph = {
    "z": "x",
    "x": "v",
    "y": "v",
    "w": "v",
    "v": "r",
    "r": "h",
    "q": "h",
    "p": "h",
    "o": "h",
    "t": "p",
    "u": "p",
    "h": "b",
    "g": "b",
    "i": "b",
    "c": "a",
    "j": "c",
    "k": "d",
    "l": "d",
    "d": "a",
    "e": "a",
    "f": "a",
    "m": "f",
    "b": "a",
    "n": "f",
    "a": None
}


def define_depth(graph: {}, el: str, level: int = 0):
    if graph[el] is None:
        return level
    return define_depth(graph, graph[el], level + 1)


def up(graph: {}, from_level, to_level, el):
    if from_level == to_level:
        return graph[el]
    return up(graph, from_level + 1, to_level, graph[el])


# Time O(h) - h - height of tree, Space O(h)
def youngest_common_ancestor(graph: {str, str}, a: str, b: str):
    level_a = define_depth(graph, a)
    level_b = define_depth(graph, b)
    cur_a_ancestor = graph[a]
    cur_b_ancestor = graph[b]
    if level_b < level_a:
        cur_a_ancestor = up(graph, level_b, level_a, a)
    elif level_b > level_a:
        cur_b_ancestor = up(graph, level_a, level_b, b)

    if cur_b_ancestor == cur_a_ancestor:
        return cur_b_ancestor
    return graph[cur_b_ancestor]
