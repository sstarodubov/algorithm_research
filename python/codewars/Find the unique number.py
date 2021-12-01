def find_uniq(arr):
    hm = {}
    for num in arr:
        if num in hm:
            hm[num] += 1
        else:
            hm[num] = 0
        if hm[num] > 2 and len(hm) == 2:
            break
    ks = list(hm.keys())
    if hm[ks[0]] > hm[ks[1]]:
        return ks[1]
    return ks[0]


assert find_uniq([3, 10, 3, 3, 3]) == 10
assert find_uniq([1, 1, 1, 2, 1, 1]) == 2
assert find_uniq([0, 0, 0.55, 0, 0]) == 0.55
print("tests passed")


assert find_uniq([3, 10, 3, 3, 3]) == 10
assert find_uniq([1, 1, 1, 2, 1, 1]) == 2
assert find_uniq([0, 0, 0.55, 0, 0]) == 0.55
print("tests passed")
