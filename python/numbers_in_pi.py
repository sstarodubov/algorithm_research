

def nums_in_PI(pi, numbers):
    table = {number: True for number in numbers}
    min_spaces = get_min_spaces(pi, table, {}, 0)
    return min_spaces

def get_min_spaces(pi, table, cache, idx):
    if idx == len(pi):
        return -1
    if idx in cache:
        return cache[idx]
    min_spaces = float("inf")
    for i in range(idx, len(pi)):
        prefix = pi[idx:i + 1]
        if prefix in table:
            min_spaces_in_suffix = get_min_spaces(pi, table, cache, i + 1)
            min_spaces = min(min_spaces, min_spaces_in_suffix + 1)
    cache[idx] = min_spaces
    return cache[idx]


print(nums_in_PI("314592", ["3141", "5", "31", "2", "4159", "9", "42"]))