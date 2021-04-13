input = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]


def search_for_range(arr: [int], l: int, r: int, k: int):
    if r <= l: return l if arr[l] == k else -1
    m = (r + l) // 2
    if arr[m] == k: return m
    if k < arr[m]:
        return search_for_range(arr, l, m - 1, k)
    return search_for_range(arr, m + 1, r, k)


r = search_for_range(input, 0, len(input) - 1, 45)
print(r)

# assert 4 == r[0], "first ele eq 4"
# assert 9 == r[1], "second ele eq 9"
