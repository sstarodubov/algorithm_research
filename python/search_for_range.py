input = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73]


def search_for_range(arr: [int], k: int) -> (int, int):
    pass


r = search_for_range(input, 45)
assert 4 == r[0], "first ele eq 4"
assert 9 == r[1], "second ele eq 9"