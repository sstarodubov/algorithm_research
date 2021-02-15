array = [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]

vertexes: {} = {
    "LH": (0, 0),
    "RH": (0, len(array[0]) - 1),
    "RL": (len(array[0]) - 1, len(array[0]) - 1),
    "LL": (len(array[0]) - 1, 0)
}


# Time O(n) Space (n)
def spirit_traverse(arr: [[int]], vertexes: {}, from_ptr: str = "LH", x=0, y=0, trace: [int] = []):
    if (len(array[0]) * len(array)) == len(trace):
        return trace
    if from_ptr == "LH":
        trace.append(arr[y][x])
        x += 1
        next_base = vertexes["RH"]
        if next_base[0] == y and next_base[1] == x:
            return spirit_traverse(arr, vertexes, "RH", x, y, trace)
        return spirit_traverse(arr, vertexes, from_ptr, x, y, trace)

    if from_ptr == "RH":
        trace.append(arr[y][x])
        y += 1
        next_base = vertexes["RL"]
        if next_base[0] == y and next_base[1] == x:
            return spirit_traverse(arr, vertexes, "RL", x, y, trace)
        return spirit_traverse(arr, vertexes, from_ptr, x, y, trace)

    if from_ptr == "RL":
        trace.append(arr[y][x])
        x -= 1
        next_base = vertexes["LL"]
        if next_base[0] == y and next_base[1] == x:
            return spirit_traverse(arr, vertexes, "LL", x, y, trace)
        return spirit_traverse(arr, vertexes, from_ptr, x, y, trace)

    if from_ptr == "LL":
        trace.append(arr[y][x])
        y -= 1
        next_base = vertexes["LH"]
        if next_base[0] == y and next_base[1] == x:
            updated_vertexes = {
                "LH": (vertexes["LH"][0] + 1, vertexes["LH"][1] + 1),
                "RH": (vertexes["RH"][0] + 1, vertexes["RH"][1] - 1),
                "RL": (vertexes["RL"][0] - 1, vertexes["RL"][1] - 1),
                "LL": (vertexes["LL"][0] - 1, vertexes["LL"][1] + 1)
            }
            return spirit_traverse(arr, updated_vertexes, "LH", x + 1, y + 1, trace)
        return spirit_traverse(arr, vertexes, from_ptr, x, y, trace)


print(spirit_traverse(array, vertexes))
