input = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]

def search_for_range(arr: [int], l: int, r: int, k: int, t:[int, int], found : bool= False):
    if r <= l: return t
    m = (r + l) // 2
    if arr[m] == k:
        found = True
        if t[1] >= m: t[1] = m
        if t[0] < m: t[0] = m
    search_for_range(arr, l, m - 1, k, t)
    search_for_range(arr, m + 1, r, k, t)
    return [t[1], t[0]] if found else [-1, -1]


r = search_for_range(input, 0, len(input) - 1, 45, [0, len(input) - 1])

assert 4 == r[0], "first ele eq 4"
assert 9 == r[1], "second ele eq 9"

assert 0 == search_for_range([0,0,0,1,2,3], 0, 5, 0, [0,5])[0]
assert 2 == search_for_range([0,0,0,1,2,3], 0, 5, 0, [0,5])[1]

assert 3 == search_for_range([0,1,2,3,3,3], 0, 6, 3, [0,6])[0]
assert 5 == search_for_range([0,1,2,3,3,3], 0, 6, 3, [0,6])[1]


assert -1 == search_for_range([0,1,2,3,3,3], 0, 6, 10, [0,6])[0]
assert -1 == search_for_range([0,1,2,3,3,3], 0, 6, 10, [0,6])[1]

print("tests passed")