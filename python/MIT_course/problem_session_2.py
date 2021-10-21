from typing import List


def perm(arr: List[int]) -> List[List[int]]:
    result = []

    if len(arr) == 1:
        return [arr]

    for letter in arr:
        tmp = perm(list(filter(lambda x: x != letter, arr)))
        tmp = list(map(lambda _set: [letter] + [*_set], tmp))
        result = [*result, *tmp]
    return result


print(perm([1, 2, 3]))
